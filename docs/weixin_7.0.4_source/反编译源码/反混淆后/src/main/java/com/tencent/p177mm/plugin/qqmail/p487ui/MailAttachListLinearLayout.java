package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout */
public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> pyN = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout$1 */
    class C347541 implements OnClickListener {
        final /* synthetic */ String pyO;
        final /* synthetic */ String pyP;
        final /* synthetic */ String pyQ;
        final /* synthetic */ long pyR;
        final /* synthetic */ int pyS;
        final /* synthetic */ String pyT;

        C347541(String str, String str2, String str3, long j, int i, String str4) {
            this.pyO = str;
            this.pyP = str2;
            this.pyQ = str3;
            this.pyR = j;
            this.pyS = i;
            this.pyT = str4;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68377);
            Intent intent = new Intent(MailAttachListLinearLayout.this.context, AttachDownloadPage.class);
            intent.putExtra("attach_name", this.pyO);
            intent.putExtra("mail_id", this.pyP);
            intent.putExtra("attach_id", this.pyQ);
            intent.putExtra("total_size", this.pyR);
            intent.putExtra("is_preview", this.pyS);
            intent.putExtra("is_compress", MailAttachListLinearLayout.m57088Vt(this.pyT));
            MailAttachListLinearLayout.this.context.startActivity(intent);
            AppMethodBeat.m2505o(68377);
        }
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(68378);
        this.context = context;
        AppMethodBeat.m2505o(68378);
    }

    /* renamed from: fI */
    static String m57090fI(String str, String str2) {
        AppMethodBeat.m2504i(68379);
        if (str == null || str.length() == 0 || str2.length() == 0) {
            AppMethodBeat.m2505o(68379);
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            AppMethodBeat.m2505o(68379);
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        String substring = str.substring((indexOf + str2.length()) + 1, indexOf2);
        AppMethodBeat.m2505o(68379);
        return substring;
    }

    /* renamed from: Vt */
    static /* synthetic */ boolean m57088Vt(String str) {
        AppMethodBeat.m2504i(68380);
        if (str == null || !str.contains("/cgi-bin/viewcompress")) {
            AppMethodBeat.m2505o(68380);
            return false;
        }
        AppMethodBeat.m2505o(68380);
        return true;
    }
}
