package org.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.imooc.bean.Dic;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DicDto extends Dic {

}
