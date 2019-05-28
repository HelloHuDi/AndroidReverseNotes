package com.tencent.mm.ui.f.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a {
    c zxr;

    public interface a {
        void a(FileNotFoundException fileNotFoundException);

        void a(MalformedURLException malformedURLException);

        void b(IOException iOException);

        void wo(String str);
    }

    /* renamed from: com.tencent.mm.ui.f.a.a$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bundle val$parameters;
        final /* synthetic */ String zxs;
        final /* synthetic */ String zxt;
        final /* synthetic */ a zxu;
        final /* synthetic */ Object zxv = null;

        public AnonymousClass1(String str, Bundle bundle, String str2, a aVar) {
            this.zxs = str;
            this.val$parameters = bundle;
            this.zxt = str2;
            this.zxu = aVar;
        }

        public final void run() {
            AppMethodBeat.i(80293);
            try {
                this.zxu.wo(a.this.zxr.a(this.zxs, this.val$parameters, this.zxt));
                AppMethodBeat.o(80293);
            } catch (FileNotFoundException e) {
                this.zxu.a(e);
                AppMethodBeat.o(80293);
            } catch (MalformedURLException e2) {
                this.zxu.a(e2);
                AppMethodBeat.o(80293);
            } catch (IOException e3) {
                this.zxu.b(e3);
                AppMethodBeat.o(80293);
            }
        }
    }

    public a(c cVar) {
        this.zxr = cVar;
    }
}
