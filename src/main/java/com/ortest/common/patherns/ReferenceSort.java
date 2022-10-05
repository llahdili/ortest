package com.ortest.common.patherns;

import com.ortest.model.Orders;
import com.ortest.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class ReferenceSort  implements ISortingStrategy {
    private OrderRepo orderRepo;

    @Autowired
    public ReferenceSort(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public String stringSequenceIdentifier() {
        Orders order = this.orderRepo.findMaxId();
        LocalDate dateNow = LocalDate.now(ZoneId.of("Africa/Casablanca"));
        if (order == null) {
            return "BC" + dateNow.format(DateTimeFormatter.ofPattern("MM-dd")) + "" + 1;
        }
        String nbrOrder = dateNow.getDayOfMonth() == 1 ? "1" : order.getReference().split("BC\\d{2}-\\d{2}")[1];
        return "BC" + dateNow.format(DateTimeFormatter.ofPattern("MM-dd")) + "" + ((nbrOrder) + 1);
    }
}

