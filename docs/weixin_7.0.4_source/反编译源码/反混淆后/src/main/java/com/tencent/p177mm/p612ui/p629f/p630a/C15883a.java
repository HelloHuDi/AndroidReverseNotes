package com.tencent.p177mm.p612ui.p629f.p630a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/* renamed from: com.tencent.mm.ui.f.a.a */
public final class C15883a {
    C30704c zxr;

    /* renamed from: com.tencent.mm.ui.f.a.a$a */
    public interface C15882a {
        /* renamed from: a */
        void mo28117a(FileNotFoundException fileNotFoundException);

        /* renamed from: a */
        void mo28118a(MalformedURLException malformedURLException);

        /* renamed from: b */
        void mo28119b(IOException iOException);

        /* renamed from: wo */
        void mo28120wo(String str);
    }

    /* renamed from: com.tencent.mm.ui.f.a.a$1 */
    public class C158841 implements Runnable {
        final /* synthetic */ Bundle val$parameters;
        final /* synthetic */ String zxs;
        final /* synthetic */ String zxt;
        final /* synthetic */ C15882a zxu;
        final /* synthetic */ Object zxv = null;

        public C158841(String str, Bundle bundle, String str2, C15882a c15882a) {
            this.zxs = str;
            this.val$parameters = bundle;
            this.zxt = str2;
            this.zxu = c15882a;
        }

        public final void run() {
            AppMethodBeat.m2504i(80293);
            try {
                this.zxu.mo28120wo(C15883a.this.zxr.mo49069a(this.zxs, this.val$parameters, this.zxt));
                AppMethodBeat.m2505o(80293);
            } catch (FileNotFoundException e) {
                this.zxu.mo28117a(e);
                AppMethodBeat.m2505o(80293);
            } catch (MalformedURLException e2) {
                this.zxu.mo28118a(e2);
                AppMethodBeat.m2505o(80293);
            } catch (IOException e3) {
                this.zxu.mo28119b(e3);
                AppMethodBeat.m2505o(80293);
            }
        }
    }

    public C15883a(C30704c c30704c) {
        this.zxr = c30704c;
    }
}
