package az.company.cards.mapper;

import az.company.cards.dao.entity.CardsEntity;
import az.company.cards.model.request.CardsRequest;
import az.company.cards.model.response.CardsResponse;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardsMapper {
    CardsMapper MAP = Mappers.getMapper(CardsMapper.class);

    default CardsEntity requestToEntity(CardsRequest request) {
        return CardsEntity
                .builder()
                .totalLimit(request.getTotalLimit())
                .cardType(request.getCardType())
                .cardNumber(request.getCardNumber())
                .customerId(request.getCustomerId())
                .availableAmount(request.getAvailableAmount())
                .amountUsed(request.getAmountUsed())
                .build();
    }

    default CardsResponse entityToResponse(CardsEntity card) {
        return CardsResponse
                .builder()
                .amountUsed(card.getAmountUsed())
                .createdAt(card.getCreatedAt())
                .availableAmount(card.getAvailableAmount())
                .cardNumber(card.getCardNumber())
                .cardType(card.getCardType())
                .customerId(card.getCustomerId())
                .totalLimit(card.getTotalLimit())
                .build();
    }

    default void updateDesiredEntityField(CardsEntity card, CardsRequest request) {
        var cardNumber = request.getCardNumber();
        var cardType = request.getCardType();
        var amountUsed = request.getAmountUsed();
        var availableAmount = request.getAvailableAmount();
        var totalLimit = request.getTotalLimit();
        var customerId = request.getCustomerId();

        if (Strings.isNotEmpty(cardNumber) &&
                Strings.isNotBlank(cardNumber)) {
            card.setCardNumber(cardNumber);
        }
        if (Strings.isNotEmpty(cardType) &&
                Strings.isNotBlank(cardType)) {
            card.setCardType(cardType);
        }
        if (amountUsed != null) {
            card.setAmountUsed(amountUsed);
        }
        if (availableAmount != null) {
            card.setAvailableAmount(availableAmount);
        }
        if (totalLimit != null) {
            card.setTotalLimit(totalLimit);
        }
        if (customerId != null) {
            card.setCustomerId(customerId);
        }
    }
}
