package com.sac.lombok;

import lombok.*;

/**
 * @author:eason
 * @Description
 * @Date: 20:17,2018/4/18
 * @ModifiedBy
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Stu {
    private String name;

    private String country;
}
