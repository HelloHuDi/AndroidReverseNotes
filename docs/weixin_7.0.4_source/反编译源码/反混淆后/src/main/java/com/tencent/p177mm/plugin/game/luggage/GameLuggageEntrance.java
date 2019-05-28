package com.tencent.p177mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.luggage.GameLuggageEntrance */
public class GameLuggageEntrance extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.game.luggage.GameLuggageEntrance$2 */
    class C342842 implements OnClickListener {
        C342842() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135799);
            new Bundle().putString("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
            Intent intent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
            intent.putExtra("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
            GameLuggageEntrance.this.startActivity(intent);
            AppMethodBeat.m2505o(135799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.GameLuggageEntrance$3 */
    class C342853 implements OnMenuItemClickListener {
        C342853() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(135800);
            GameLuggageEntrance.this.finish();
            AppMethodBeat.m2505o(135800);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(135801);
        super.onCreate(bundle);
        final EditText editText = (EditText) findViewById(2131825692);
        ((Button) findViewById(2131825693)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(135798);
                String obj = editText.getText().toString();
                if (!C5046bo.isNullOrNil(obj)) {
                    new Bundle().putString("rawUrl", obj);
                    Intent intent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
                    intent.putExtra("rawUrl", obj);
                    GameLuggageEntrance.this.startActivity(intent);
                }
                AppMethodBeat.m2505o(135798);
            }
        });
        ((Button) findViewById(2131825694)).setOnClickListener(new C342842());
        setBackBtn(new C342853());
        AppMethodBeat.m2505o(135801);
    }

    public final int getLayoutId() {
        return 2130970012;
    }
}
