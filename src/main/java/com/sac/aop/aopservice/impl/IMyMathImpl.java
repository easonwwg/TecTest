package com.sac.aop.aopservice.impl;

import com.sac.aop.aopservice.IMyMath;
import org.springframework.stereotype.Service;

/**
 * @author:eason
 * @Description
 * @Date: 20:24,2018/4/24
 * @ModifiedBy
 */
@Service
public class IMyMathImpl implements IMyMath {

    @Override
    public int add(int n1, int n2) {
        return n1 + n2;
    }
}
