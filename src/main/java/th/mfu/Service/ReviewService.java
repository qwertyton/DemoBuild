package th.mfu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.Domain.Booking;
import th.mfu.Model.BookingModel;
import th.mfu.Repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    BookingRepository bookingRepository;

    public List<BookingModel> review(String name){
        List<BookingModel> result = new ArrayList<>();
        try {
            List<Booking> bookingList = bookingRepository.findAllByName(name);
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}