package com.wtr.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：Tangren_ on 2017/4/28 0028.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */

@Module
public class TRModule {

    @Provides
    Person providerPerson() {
        return new Person();
    }
}
