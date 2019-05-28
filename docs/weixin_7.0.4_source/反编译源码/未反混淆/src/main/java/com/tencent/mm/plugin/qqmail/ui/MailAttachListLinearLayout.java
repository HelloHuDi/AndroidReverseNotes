package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> pyN = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String pyO;
        final /* synthetic */ String pyP;
        final /* synthetic */ String pyQ;
        final /* synthetic */ long pyR;
        final /* synthetic */ int pyS;
        final /* synthetic */ String pyT;

        AnonymousClass1(String str, String str2, String str3, long j, int i, String str4) {
            this.pyO = str;
            this.pyP = str2;
            this.pyQ = str3;
            this.pyR = j;
            this.pyS = i;
            this.pyT = str4;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(68377);
            Intent intent = new Intent(MailAttachListLinearLayout.this.context, AttachDownloadPage.class);
            intent.putExtra("attach_name", this.pyO);
            intent.putExtra("mail_id", this.pyP);
            intent.putExtra("attach_id", this.pyQ);
            intent.putExtra("total_size", this.pyR);
            intent.putExtra("is_preview", this.pyS);
            intent.putExtra("is_compress", MailAttachListLinearLayout.Vt(this.pyT));
            MailAttachListLinearLayout.this.context.startActivity(intent);
            AppMethodBeat.o(68377);
        }
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(68378);
        this.context = context;
        AppMethodBeat.o(68378);
    }

    static String fI(String str, String str2) {
        AppMethodBeat.i(68379);
        if (str == null || str.length() == 0 || str2.length() == 0) {
            AppMethodBeat.o(68379);
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            AppMethodBeat.o(68379);
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        String substring = str.substring((indexOf + str2.length()) + 1, indexOf2);
        AppMethodBeat.o(68379);
        return substring;
    }

    static /* synthetic */ boolean Vt(String str) {
        AppMethodBeat.i(68380);
        if (str == null || !str.contains("/cgi-bin/viewcompress")) {
            AppMethodBeat.o(68380);
            return false;
        }
        AppMethodBeat.o(68380);
        return true;
    }
}
