package com.tencent.mm.plugin.nearby.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView ejo;
    String oPX = "";
    View oPY = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55429);
        super.onCreate(bundle);
        setMMTitle((int) R.string.d57);
        initView();
        AppMethodBeat.o(55429);
    }

    public void onResume() {
        AppMethodBeat.i(55430);
        super.onResume();
        TextView textView = (TextView) findViewById(R.id.c_z);
        g.RN().QU();
        int baS = ((j) g.K(j.class)).bOo().baS();
        if (baS == 0) {
            this.oPY.setVisibility(4);
            AppMethodBeat.o(55430);
            return;
        }
        textView.setText(getResources().getQuantityString(R.plurals.a1, baS, new Object[]{Integer.valueOf(baS)}));
        this.ejo = (ImageView) findViewById(R.id.c_y);
        bf bOx = ((j) g.K(j.class)).bOo().bOx();
        if (bOx != null) {
            this.oPX = bOx.field_sayhiuser;
            b.b(this.ejo, this.oPX);
        }
        AppMethodBeat.o(55430);
    }

    public void onPause() {
        AppMethodBeat.i(55431);
        super.onPause();
        AppMethodBeat.o(55431);
    }

    public final int getLayoutId() {
        return R.layout.aii;
    }

    public final void initView() {
        AppMethodBeat.i(55432);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55426);
                NearbyFriendShowSayHiUI.this.aqX();
                NearbyFriendShowSayHiUI.this.finish();
                AppMethodBeat.o(55426);
                return true;
            }
        });
        ((Button) findViewById(R.id.dgk)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55427);
                NearbyFriendShowSayHiUI.this.startActivity(new Intent(NearbyFriendShowSayHiUI.this, NearbyFriendsUI.class));
                AppMethodBeat.o(55427);
            }
        });
        this.oPY = findViewById(R.id.c_x);
        this.oPY.setVisibility(0);
        this.oPY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55428);
                Intent intent = new Intent(NearbyFriendShowSayHiUI.this, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                intent.putExtra("show_clear_header", true);
                NearbyFriendShowSayHiUI.this.startActivityForResult(intent, 2009);
                AppMethodBeat.o(55428);
            }
        });
        AppMethodBeat.o(55432);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(55433);
        if (i == 2009 && i2 == -1) {
            finish();
        }
        AppMethodBeat.o(55433);
    }
}
