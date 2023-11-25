package th.mfu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.Domain.Booking;
import th.mfu.Domain.Station;
import th.mfu.Model.BookingModel;
import th.mfu.Repository.BookingRepository;
import th.mfu.Repository.StationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    StationRepository stationRepository;

    public List<BookingModel> booking(BookingModel data){
        List<BookingModel> result = new ArrayList<>();
        try {
            System.out.println(data.getFieldTwo());
            System.out.println(data.getFieldOne());
            System.out.println(data.getFieldFive());
            Station stationDetail = stationRepository.findAllByNameAndTime(data.getFieldTwo(),data.getFieldOne());
            System.out.println(stationDetail.getName());
            System.out.println(stationDetail.getStatus());
            System.out.println(stationDetail.getTime());
            if (stationDetail != null && stationDetail.getStatus() == null){
                Booking bookingData = new Booking();
                bookingData.setName(data.getName());
                bookingData.setFieldOne(data.getFieldOne());
                bookingData.setFieldTwo(data.getFieldTwo());
                bookingData.setFieldThree(data.getFieldThree());
                bookingData.setFieldFour(data.getFieldFore());
                bookingData.setFieldFive(data.getFieldFive());
                bookingRepository.save(bookingData);
                List<Booking> bookingList = bookingRepository.findAllByName(data.getName());
                for (Booking book: bookingList){
                    BookingModel bookData = new BookingModel();
                    bookData.setName(book.getName());
                    bookData.setFieldOne(book.getFieldOne());
                    bookData.setFieldTwo(book.getFieldTwo());
                    bookData.setFieldThree(book.getFieldThree());
                    bookData.setFieldFour(book.getFieldFore());
                    bookData.setFieldFive(book.getFieldFive());
                    result.add(bookData);
                }
                stationDetail.setStatus(data.getName());
                stationRepository.save(stationDetail);
            }else{
                result = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}