package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class GameLuggageEntrance extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(135801);
        super.onCreate(bundle);
        final EditText editText = (EditText) findViewById(R.id.d16);
        ((Button) findViewById(R.id.d17)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(135798);
                String obj = editText.getText().toString();
                if (!bo.isNullOrNil(obj)) {
                    new Bundle().putString("rawUrl", obj);
                    Intent intent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
                    intent.putExtra("rawUrl", obj);
                    GameLuggageEntrance.this.startActivity(intent);
                }
                AppMethodBeat.o(135798);
            }
        });
        ((Button) findViewById(R.id.d18)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(135799);
                new Bundle().putString("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
                Intent intent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
                intent.putExtra("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
                GameLuggageEntrance.this.startActivity(intent);
                AppMethodBeat.o(135799);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(135800);
                GameLuggageEntrance.this.finish();
                AppMethodBeat.o(135800);
                return false;
            }
        });
        AppMethodBeat.o(135801);
    }

    public final int getLayoutId() {
        return R.layout.ab0;
    }
}
