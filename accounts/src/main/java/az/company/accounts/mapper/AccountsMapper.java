package az.company.accounts.mapper;

import az.company.accounts.dao.entity.AccountsEntity;
import az.company.accounts.model.request.AccountsRequest;
import az.company.accounts.model.response.AccountsResponse;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountsMapper {
    AccountsMapper MAP = Mappers.getMapper(AccountsMapper.class);

    AccountsEntity requestToEntity(AccountsRequest request);

    AccountsResponse entityToResponse(AccountsEntity account);

    default void updateDesiredEntityField(AccountsEntity account, AccountsRequest request) {
        if (Strings.isNotEmpty(request.getAccountType()) &&
                Strings.isNotBlank(request.getAccountType()))
            account.setAccountType(request.getAccountType());

        if (Strings.isNotEmpty(request.getBranchAddress()) &&
                Strings.isNotBlank(request.getBranchAddress()))
            account.setBranchAddress(request.getBranchAddress());

        if (request.getCustomerId() != null)
            account.setCustomerId(request.getCustomerId());
    }
}
