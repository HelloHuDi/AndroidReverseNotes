package com.tencent.mm.plugin.emojicapture.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureBeautySettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "chinInputText", "Landroid/widget/EditText;", "eyeInputText", "faceVInputText", "noseInputText", "shapeInputText", "skinInputText", "clamp", "", "value", "min", "max", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "saveParam", "plugin-emojicapture_release"})
public final class EmojiCaptureBeautySettingUI extends MMActivity {
    private EditText lkU;
    private EditText lkV;
    private EditText lkW;
    private EditText lkX;
    private EditText lkY;
    private EditText lkZ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements OnMenuItemClickListener {
        final /* synthetic */ EmojiCaptureBeautySettingUI lla;

        a(EmojiCaptureBeautySettingUI emojiCaptureBeautySettingUI) {
            this.lla = emojiCaptureBeautySettingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(2856);
            this.lla.finish();
            AppMethodBeat.o(2856);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(2857);
        super.onCreate(bundle);
        setBackBtn(new a(this));
        View findViewById = findViewById(R.id.bch);
        v vVar;
        if (findViewById == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.o(2857);
            throw vVar;
        }
        this.lkU = (EditText) findViewById;
        findViewById = findViewById(R.id.bci);
        if (findViewById == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.o(2857);
            throw vVar;
        }
        this.lkV = (EditText) findViewById;
        findViewById = findViewById(R.id.bcj);
        if (findViewById == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.o(2857);
            throw vVar;
        }
        this.lkW = (EditText) findViewById;
        findViewById = findViewById(R.id.bck);
        if (findViewById == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.o(2857);
            throw vVar;
        }
        this.lkX = (EditText) findViewById;
        findViewById = findViewById(R.id.bcl);
        if (findViewById == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.o(2857);
            throw vVar;
        }
        this.lkY = (EditText) findViewById;
        findViewById = findViewById(R.id.bcm);
        if (findViewById == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.o(2857);
            throw vVar;
        }
        this.lkZ = (EditText) findViewById;
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
        int i = sharedPreferences.getInt("skin", 50);
        int i2 = sharedPreferences.getInt("shape", 20);
        int i3 = sharedPreferences.getInt("faceV", 0);
        int i4 = sharedPreferences.getInt("eye", 0);
        int i5 = sharedPreferences.getInt("nose", 0);
        int i6 = sharedPreferences.getInt("chin", 0);
        EditText editText = this.lkU;
        if (editText == null) {
            j.avw("skinInputText");
        }
        editText.setText(String.valueOf(i));
        EditText editText2 = this.lkV;
        if (editText2 == null) {
            j.avw("shapeInputText");
        }
        editText2.setText(String.valueOf(i2));
        editText2 = this.lkW;
        if (editText2 == null) {
            j.avw("faceVInputText");
        }
        editText2.setText(String.valueOf(i3));
        editText2 = this.lkX;
        if (editText2 == null) {
            j.avw("eyeInputText");
        }
        editText2.setText(String.valueOf(i4));
        editText2 = this.lkY;
        if (editText2 == null) {
            j.avw("noseInputText");
        }
        editText2.setText(String.valueOf(i5));
        editText2 = this.lkZ;
        if (editText2 == null) {
            j.avw("chinInputText");
        }
        editText2.setText(String.valueOf(i6));
        AppMethodBeat.o(2857);
    }

    public final int getLayoutId() {
        return R.layout.te;
    }

    public final void onDestroy() {
        AppMethodBeat.i(2858);
        super.onDestroy();
        EditText editText = this.lkU;
        if (editText == null) {
            j.avw("skinInputText");
        }
        int i = com.tencent.mm.c.j.getInt(editText.getText().toString(), -1);
        EditText editText2 = this.lkV;
        if (editText2 == null) {
            j.avw("shapeInputText");
        }
        int i2 = com.tencent.mm.c.j.getInt(editText2.getText().toString(), -1);
        EditText editText3 = this.lkW;
        if (editText3 == null) {
            j.avw("faceVInputText");
        }
        int i3 = com.tencent.mm.c.j.getInt(editText3.getText().toString(), -1);
        EditText editText4 = this.lkX;
        if (editText4 == null) {
            j.avw("eyeInputText");
        }
        int i4 = com.tencent.mm.c.j.getInt(editText4.getText().toString(), -1);
        EditText editText5 = this.lkY;
        if (editText5 == null) {
            j.avw("noseInputText");
        }
        int i5 = com.tencent.mm.c.j.getInt(editText5.getText().toString(), -1);
        EditText editText6 = this.lkZ;
        if (editText6 == null) {
            j.avw("chinInputText");
        }
        int i6 = com.tencent.mm.c.j.getInt(editText6.getText().toString(), -1);
        Editor edit = ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0).edit();
        edit.putInt("skin", dW(i, 0));
        edit.putInt("shape", dW(i2, 0));
        edit.putInt("faceV", dW(i3, 0));
        edit.putInt("eye", dW(i4, 0));
        edit.putInt("nose", dW(i5, 0));
        edit.putInt("chin", dW(i6, -100));
        edit.commit();
        AppMethodBeat.o(2858);
    }

    private static int dW(int i, int i2) {
        AppMethodBeat.i(2859);
        int min = Math.min(100, Math.max(i2, i));
        AppMethodBeat.o(2859);
        return min;
    }
}
