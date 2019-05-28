package com.tencent.mm.storage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.o.a;

public final class ak extends a implements com.tencent.mm.cd.a.a<String> {
    public bi xXq;

    public ak(String str) {
        super(str);
    }

    public final void dsI() {
        AppMethodBeat.i(60131);
        setStatus(0);
        hO(0);
        setContent("");
        jg(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hM(0);
        hU(0);
        eF(0);
        hT(0);
        hT(0);
        super.jh("");
        super.ji("");
        AppMethodBeat.o(60131);
    }

    public final void q(int i, byte[] bArr) {
    }

    public final void bK(int i, String str) {
        AppMethodBeat.i(60133);
        switch (i) {
            case 4:
                setUsername(str);
                AppMethodBeat.o(60133);
                return;
            case 5:
                setContent(str);
                AppMethodBeat.o(60133);
                return;
            case 6:
                jg(str);
                AppMethodBeat.o(60133);
                return;
            case 8:
                jh(str);
                AppMethodBeat.o(60133);
                return;
            case 9:
                ji(str);
                AppMethodBeat.o(60133);
                return;
            case 11:
                jk(str);
                break;
        }
        AppMethodBeat.o(60133);
    }

    public final void drw() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ap(bi biVar) {
        ak akVar;
        long j;
        ak akVar2;
        AppMethodBeat.i(60130);
        setStatus(biVar.field_status);
        hO(biVar.field_isSend);
        if (biVar.bwt()) {
            akVar = this;
        } else if (biVar.field_status == 1) {
            j = Long.MAX_VALUE;
            akVar2 = this;
            akVar2.eD(j);
            if (biVar.dtv()) {
                setContent(biVar.field_content);
                AppMethodBeat.o(60130);
                return;
            }
            setContent(biVar.dtW());
            AppMethodBeat.o(60130);
            return;
        } else {
            akVar = this;
        }
        j = biVar.field_createTime;
        akVar2 = akVar;
        akVar2.eD(j);
        if (biVar.dtv()) {
        }
    }

    public final void ag(int i, long j) {
        AppMethodBeat.i(60132);
        switch (i) {
            case 0:
                hM((int) j);
                AppMethodBeat.o(60132);
                return;
            case 1:
                setStatus((int) j);
                AppMethodBeat.o(60132);
                return;
            case 2:
                hO((int) j);
                AppMethodBeat.o(60132);
                return;
            case 3:
                eD(j);
                AppMethodBeat.o(60132);
                return;
            case 7:
                eE(j);
                AppMethodBeat.o(60132);
                return;
            case 10:
                hQ((int) j);
                AppMethodBeat.o(60132);
                return;
            case 12:
                hR((int) j);
                AppMethodBeat.o(60132);
                return;
            case 13:
                hS((int) j);
                AppMethodBeat.o(60132);
                return;
            case 14:
                hU((int) j);
                break;
        }
        AppMethodBeat.o(60132);
    }

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }
}
