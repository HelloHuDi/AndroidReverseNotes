package com.tencent.p177mm.plugin.forcenotify.p415ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.forcenotify.p1263b.C43100c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p001a.C25035t;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "username", "getUsername", "setUsername", "(Ljava/lang/String;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI */
public abstract class BaseForceNotifyShowUI extends MMActivity {
    final String TAG = "MicroMsg.ForceNotifyListUI";
    String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI$a */
    static final class C28064a implements OnMenuItemClickListener {
        final /* synthetic */ BaseForceNotifyShowUI mti;

        C28064a(BaseForceNotifyShowUI baseForceNotifyShowUI) {
            this.mti = baseForceNotifyShowUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(51063);
            this.mti.onBackPressed();
            AppMethodBeat.m2505o(51063);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8367c9);
        getWindow().addFlags(6815872);
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        setBackBtn(new C28064a(this));
        if (!C43100c.mtf.msT.isEmpty()) {
            this.username = (String) C25035t.m39335e(C43100c.mtf.msT);
        }
        if (TextUtils.isEmpty(this.username)) {
            C4990ab.m7412e(this.TAG, "username is null");
            this.username = "";
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0, C25738R.anim.f8373ce);
    }

    public void onDestroy() {
        super.onDestroy();
        C43100c.mtf.msT.remove(this.username);
        if (!C43100c.mtf.msT.isEmpty()) {
            startActivity(getIntent());
        }
        C4990ab.m7416i(this.TAG, "[onDestroy]");
    }
}
