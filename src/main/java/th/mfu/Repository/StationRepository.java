package th.mfu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.mfu.Domain.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
    Station findAllByNameAndTime(String name,String time);

}
