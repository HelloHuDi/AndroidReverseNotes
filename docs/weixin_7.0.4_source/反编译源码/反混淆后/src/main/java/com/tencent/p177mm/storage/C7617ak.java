package com.tencent.p177mm.storage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.p214a.C1351a;
import com.tencent.p177mm.p761o.C7487a;

/* renamed from: com.tencent.mm.storage.ak */
public final class C7617ak extends C7487a implements C1351a<String> {
    public C7620bi xXq;

    public C7617ak(String str) {
        super(str);
    }

    public final void dsI() {
        AppMethodBeat.m2504i(60131);
        setStatus(0);
        mo14750hO(0);
        setContent("");
        mo14757jg(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        mo14748hM(0);
        mo14756hU(0);
        mo14744eF(0);
        mo14755hT(0);
        mo14755hT(0);
        super.mo14758jh("");
        super.mo14759ji("");
        AppMethodBeat.m2505o(60131);
    }

    /* renamed from: q */
    public final void mo4704q(int i, byte[] bArr) {
    }

    /* renamed from: bK */
    public final void mo4701bK(int i, String str) {
        AppMethodBeat.m2504i(60133);
        switch (i) {
            case 4:
                setUsername(str);
                AppMethodBeat.m2505o(60133);
                return;
            case 5:
                setContent(str);
                AppMethodBeat.m2505o(60133);
                return;
            case 6:
                mo14757jg(str);
                AppMethodBeat.m2505o(60133);
                return;
            case 8:
                mo14758jh(str);
                AppMethodBeat.m2505o(60133);
                return;
            case 9:
                mo14759ji(str);
                AppMethodBeat.m2505o(60133);
                return;
            case 11:
                mo14761jk(str);
                break;
        }
        AppMethodBeat.m2505o(60133);
    }

    public final void drw() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ap */
    public final void mo17068ap(C7620bi c7620bi) {
        C7617ak c7617ak;
        long j;
        C7617ak c7617ak2;
        AppMethodBeat.m2504i(60130);
        setStatus(c7620bi.field_status);
        mo14750hO(c7620bi.field_isSend);
        if (c7620bi.bwt()) {
            c7617ak = this;
        } else if (c7620bi.field_status == 1) {
            j = Long.MAX_VALUE;
            c7617ak2 = this;
            c7617ak2.mo14742eD(j);
            if (c7620bi.dtv()) {
                setContent(c7620bi.field_content);
                AppMethodBeat.m2505o(60130);
                return;
            }
            setContent(c7620bi.dtW());
            AppMethodBeat.m2505o(60130);
            return;
        } else {
            c7617ak = this;
        }
        j = c7620bi.field_createTime;
        c7617ak2 = c7617ak;
        c7617ak2.mo14742eD(j);
        if (c7620bi.dtv()) {
        }
    }

    /* renamed from: ag */
    public final void mo4700ag(int i, long j) {
        AppMethodBeat.m2504i(60132);
        switch (i) {
            case 0:
                mo14748hM((int) j);
                AppMethodBeat.m2505o(60132);
                return;
            case 1:
                setStatus((int) j);
                AppMethodBeat.m2505o(60132);
                return;
            case 2:
                mo14750hO((int) j);
                AppMethodBeat.m2505o(60132);
                return;
            case 3:
                mo14742eD(j);
                AppMethodBeat.m2505o(60132);
                return;
            case 7:
                mo14743eE(j);
                AppMethodBeat.m2505o(60132);
                return;
            case 10:
                mo14752hQ((int) j);
                AppMethodBeat.m2505o(60132);
                return;
            case 12:
                mo14753hR((int) j);
                AppMethodBeat.m2505o(60132);
                return;
            case 13:
                mo14754hS((int) j);
                AppMethodBeat.m2505o(60132);
                return;
            case 14:
                mo14756hU((int) j);
                break;
        }
        AppMethodBeat.m2505o(60132);
    }

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }
}
