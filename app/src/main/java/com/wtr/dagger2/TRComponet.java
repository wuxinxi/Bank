package com.wtr.dagger2;

import dagger.Component;

/**
 * 作者：Tangren_ on 2017/4/28 0028.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */

@Component(modules = TRModule.class)
public interface TRComponet {
    void inject(TRActivity activity);
}
