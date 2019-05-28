package com.tencent.mm.media.b;

import a.f.b.j;
import a.l;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0011H\u0014J\r\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0004\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class b<T> {
    protected T eTh;

    public abstract T Uu();

    public abstract void Uv();

    /* Access modifiers changed, original: protected|final */
    public final T Ut() {
        Object obj = this.eTh;
        if (obj == null) {
            j.avw("elementConfig");
        }
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aQ(T t) {
        j.p(t, "<set-?>");
        this.eTh = t;
    }

    /* Access modifiers changed, original: protected */
    public int L(String str, int i) {
        j.p(str, "key");
        if (!ah.bqo()) {
            return bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig(str), i);
        }
        a K = g.K(com.tencent.mm.plugin.zero.b.a.class);
        j.o(K, "MMKernel.service<IConfig…onfigService::class.java)");
        return bo.getInt(((com.tencent.mm.plugin.zero.b.a) K).Nu().getValue(str), i);
    }

    public final T Uw() {
        this.eTh = Uu();
        Uv();
        Object obj = this.eTh;
        if (obj == null) {
            j.avw("elementConfig");
        }
        return obj;
    }
}
