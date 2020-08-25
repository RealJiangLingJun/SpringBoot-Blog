package com.jiangjiawei.hutool;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;

public class MD5Test {


    @Test
    public void MD5(){
        System.out.println(DigestUtil.md5Hex("root"));
//        63a9f0ea7bb98050796b649e85481845
    }

}
