package motian.dao.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class BaseData extends AbstractJsonObject {
    private long addTime;
    private long updateTime;

}
