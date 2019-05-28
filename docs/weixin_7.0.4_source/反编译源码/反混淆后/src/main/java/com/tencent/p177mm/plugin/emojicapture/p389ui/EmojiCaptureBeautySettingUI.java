package com.tencent.p177mm.plugin.emojicapture.p389ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p209c.C41915j;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureBeautySettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "chinInputText", "Landroid/widget/EditText;", "eyeInputText", "faceVInputText", "noseInputText", "shapeInputText", "skinInputText", "clamp", "", "value", "min", "max", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "saveParam", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI */
public final class EmojiCaptureBeautySettingUI extends MMActivity {
    private EditText lkU;
    private EditText lkV;
    private EditText lkW;
    private EditText lkX;
    private EditText lkY;
    private EditText lkZ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI$a */
    static final class C34009a implements OnMenuItemClickListener {
        final /* synthetic */ EmojiCaptureBeautySettingUI lla;

        C34009a(EmojiCaptureBeautySettingUI emojiCaptureBeautySettingUI) {
            this.lla = emojiCaptureBeautySettingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(2856);
            this.lla.finish();
            AppMethodBeat.m2505o(2856);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(2857);
        super.onCreate(bundle);
        setBackBtn(new C34009a(this));
        View findViewById = findViewById(2131823411);
        C44941v c44941v;
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.m2505o(2857);
            throw c44941v;
        }
        this.lkU = (EditText) findViewById;
        findViewById = findViewById(2131823412);
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.m2505o(2857);
            throw c44941v;
        }
        this.lkV = (EditText) findViewById;
        findViewById = findViewById(2131823413);
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.m2505o(2857);
            throw c44941v;
        }
        this.lkW = (EditText) findViewById;
        findViewById = findViewById(2131823414);
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.m2505o(2857);
            throw c44941v;
        }
        this.lkX = (EditText) findViewById;
        findViewById = findViewById(2131823415);
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.m2505o(2857);
            throw c44941v;
        }
        this.lkY = (EditText) findViewById;
        findViewById = findViewById(2131823416);
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.EditText");
            AppMethodBeat.m2505o(2857);
            throw c44941v;
        }
        this.lkZ = (EditText) findViewById;
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
        int i = sharedPreferences.getInt("skin", 50);
        int i2 = sharedPreferences.getInt("shape", 20);
        int i3 = sharedPreferences.getInt("faceV", 0);
        int i4 = sharedPreferences.getInt("eye", 0);
        int i5 = sharedPreferences.getInt("nose", 0);
        int i6 = sharedPreferences.getInt("chin", 0);
        EditText editText = this.lkU;
        if (editText == null) {
            C25052j.avw("skinInputText");
        }
        editText.setText(String.valueOf(i));
        EditText editText2 = this.lkV;
        if (editText2 == null) {
            C25052j.avw("shapeInputText");
        }
        editText2.setText(String.valueOf(i2));
        editText2 = this.lkW;
        if (editText2 == null) {
            C25052j.avw("faceVInputText");
        }
        editText2.setText(String.valueOf(i3));
        editText2 = this.lkX;
        if (editText2 == null) {
            C25052j.avw("eyeInputText");
        }
        editText2.setText(String.valueOf(i4));
        editText2 = this.lkY;
        if (editText2 == null) {
            C25052j.avw("noseInputText");
        }
        editText2.setText(String.valueOf(i5));
        editText2 = this.lkZ;
        if (editText2 == null) {
            C25052j.avw("chinInputText");
        }
        editText2.setText(String.valueOf(i6));
        AppMethodBeat.m2505o(2857);
    }

    public final int getLayoutId() {
        return 2130969322;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(2858);
        super.onDestroy();
        EditText editText = this.lkU;
        if (editText == null) {
            C25052j.avw("skinInputText");
        }
        int i = C41915j.getInt(editText.getText().toString(), -1);
        EditText editText2 = this.lkV;
        if (editText2 == null) {
            C25052j.avw("shapeInputText");
        }
        int i2 = C41915j.getInt(editText2.getText().toString(), -1);
        EditText editText3 = this.lkW;
        if (editText3 == null) {
            C25052j.avw("faceVInputText");
        }
        int i3 = C41915j.getInt(editText3.getText().toString(), -1);
        EditText editText4 = this.lkX;
        if (editText4 == null) {
            C25052j.avw("eyeInputText");
        }
        int i4 = C41915j.getInt(editText4.getText().toString(), -1);
        EditText editText5 = this.lkY;
        if (editText5 == null) {
            C25052j.avw("noseInputText");
        }
        int i5 = C41915j.getInt(editText5.getText().toString(), -1);
        EditText editText6 = this.lkZ;
        if (editText6 == null) {
            C25052j.avw("chinInputText");
        }
        int i6 = C41915j.getInt(editText6.getText().toString(), -1);
        Editor edit = C4996ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0).edit();
        edit.putInt("skin", EmojiCaptureBeautySettingUI.m55710dW(i, 0));
        edit.putInt("shape", EmojiCaptureBeautySettingUI.m55710dW(i2, 0));
        edit.putInt("faceV", EmojiCaptureBeautySettingUI.m55710dW(i3, 0));
        edit.putInt("eye", EmojiCaptureBeautySettingUI.m55710dW(i4, 0));
        edit.putInt("nose", EmojiCaptureBeautySettingUI.m55710dW(i5, 0));
        edit.putInt("chin", EmojiCaptureBeautySettingUI.m55710dW(i6, -100));
        edit.commit();
        AppMethodBeat.m2505o(2858);
    }

    /* renamed from: dW */
    private static int m55710dW(int i, int i2) {
        AppMethodBeat.m2504i(2859);
        int min = Math.min(100, Math.max(i2, i));
        AppMethodBeat.m2505o(2859);
        return min;
    }
}
