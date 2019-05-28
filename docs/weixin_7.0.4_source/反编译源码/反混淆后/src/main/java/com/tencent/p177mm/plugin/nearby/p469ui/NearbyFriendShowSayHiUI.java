package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.storage.C7570bf;

/* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI */
public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView ejo;
    String oPX = "";
    View oPY = null;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI$1 */
    class C213541 implements OnMenuItemClickListener {
        C213541() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55426);
            NearbyFriendShowSayHiUI.this.aqX();
            NearbyFriendShowSayHiUI.this.finish();
            AppMethodBeat.m2505o(55426);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI$3 */
    class C213553 implements OnClickListener {
        C213553() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55428);
            Intent intent = new Intent(NearbyFriendShowSayHiUI.this, NearbySayHiListUI.class);
            intent.putExtra("k_say_hi_type", 2);
            intent.putExtra("show_clear_header", true);
            NearbyFriendShowSayHiUI.this.startActivityForResult(intent, 2009);
            AppMethodBeat.m2505o(55428);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI$2 */
    class C285932 implements OnClickListener {
        C285932() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55427);
            NearbyFriendShowSayHiUI.this.startActivity(new Intent(NearbyFriendShowSayHiUI.this, NearbyFriendsUI.class));
            AppMethodBeat.m2505o(55427);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55429);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.d57);
        initView();
        AppMethodBeat.m2505o(55429);
    }

    public void onResume() {
        AppMethodBeat.m2504i(55430);
        super.onResume();
        TextView textView = (TextView) findViewById(2131824687);
        C1720g.m3534RN().mo5159QU();
        int baS = ((C6982j) C1720g.m3528K(C6982j.class)).bOo().baS();
        if (baS == 0) {
            this.oPY.setVisibility(4);
            AppMethodBeat.m2505o(55430);
            return;
        }
        textView.setText(getResources().getQuantityString(C25738R.plurals.f9615a1, baS, new Object[]{Integer.valueOf(baS)}));
        this.ejo = (ImageView) findViewById(2131824686);
        C7570bf bOx = ((C6982j) C1720g.m3528K(C6982j.class)).bOo().bOx();
        if (bOx != null) {
            this.oPX = bOx.field_sayhiuser;
            C40460b.m69434b(this.ejo, this.oPX);
        }
        AppMethodBeat.m2505o(55430);
    }

    public void onPause() {
        AppMethodBeat.m2504i(55431);
        super.onPause();
        AppMethodBeat.m2505o(55431);
    }

    public final int getLayoutId() {
        return 2130970290;
    }

    public final void initView() {
        AppMethodBeat.m2504i(55432);
        setBackBtn(new C213541());
        ((Button) findViewById(2131826299)).setOnClickListener(new C285932());
        this.oPY = findViewById(2131824685);
        this.oPY.setVisibility(0);
        this.oPY.setOnClickListener(new C213553());
        AppMethodBeat.m2505o(55432);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(55433);
        if (i == 2009 && i2 == -1) {
            finish();
        }
        AppMethodBeat.m2505o(55433);
    }
}
