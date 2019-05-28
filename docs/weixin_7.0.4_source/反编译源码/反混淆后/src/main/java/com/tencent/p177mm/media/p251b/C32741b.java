package com.tencent.p177mm.media.p251b;

import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0011H\u0014J\r\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0004\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.b.b */
public abstract class C32741b<T> {
    protected T eTh;

    /* renamed from: Uu */
    public abstract T mo25944Uu();

    /* renamed from: Uv */
    public abstract void mo25945Uv();

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Ut */
    public final T mo53287Ut() {
        Object obj = this.eTh;
        if (obj == null) {
            C25052j.avw("elementConfig");
        }
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aQ */
    public final void mo53289aQ(T t) {
        C25052j.m39376p(t, "<set-?>");
        this.eTh = t;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: L */
    public int mo45628L(String str, int i) {
        C25052j.m39376p(str, "key");
        if (!C4996ah.bqo()) {
            return C5046bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig(str), i);
        }
        C1694a K = C1720g.m3528K(C7234a.class);
        C25052j.m39375o(K, "MMKernel.service<IConfig…onfigService::class.java)");
        return C5046bo.getInt(((C7234a) K).mo15608Nu().getValue(str), i);
    }

    /* renamed from: Uw */
    public final T mo53288Uw() {
        this.eTh = mo25944Uu();
        mo25945Uv();
        Object obj = this.eTh;
        if (obj == null) {
            C25052j.avw("elementConfig");
        }
        return obj;
    }
}
