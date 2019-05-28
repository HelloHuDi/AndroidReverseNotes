package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI */
public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    /* renamed from: PI */
    private Cursor f17211PI;
    private C7306ak mHandler;
    private RingtoneManager qoA;
    LayoutInflater qoB;
    private int qoC = -1;
    private int qoD = -1;
    private Ringtone qoE;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI$a */
    class C28958a extends BaseAdapter {
        int count = 0;
        Cursor cyz;
        int padding = 0;

        public C28958a(Cursor cursor) {
            AppMethodBeat.m2504i(127426);
            this.cyz = cursor;
            this.count = cursor.getCount() + 1;
            C4990ab.m7410d("RingtonePickerActivity", "count = " + this.count);
            this.padding = SettingsRingtoneUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
            AppMethodBeat.m2505o(127426);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(127427);
            CheckedTextView checkedTextView = (CheckedTextView) SettingsRingtoneUI.this.qoB.inflate(2130970591, null);
            if (i == 0) {
                checkedTextView.setBackgroundResource(C25738R.drawable.f6623k5);
                checkedTextView.setText(C25738R.string.e9l);
            } else {
                checkedTextView.setBackgroundResource(C25738R.drawable.f6623k5);
                checkedTextView.setText(getItem(i));
            }
            checkedTextView.setPadding(this.padding, 0, this.padding, 0);
            checkedTextView.setCheckMarkDrawable(C25738R.drawable.f7022yu);
            AppMethodBeat.m2505o(127427);
            return checkedTextView;
        }

        public final int getCount() {
            return this.count;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(127428);
            String str;
            if (this.cyz.isClosed() || !this.cyz.moveToPosition(i - 1)) {
                str = "";
                AppMethodBeat.m2505o(127428);
                return str;
            }
            str = this.cyz.getString(this.cyz.getColumnIndex("title"));
            AppMethodBeat.m2505o(127428);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI$1 */
    class C348841 implements OnMenuItemClickListener {
        C348841() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127424);
            SettingsRingtoneUI.this.aqX();
            SettingsRingtoneUI.this.finish();
            AppMethodBeat.m2505o(127424);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI$2 */
    class C396772 implements OnMenuItemClickListener {
        C396772() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127425);
            Editor edit = SettingsRingtoneUI.this.getSharedPreferences(C4996ah.doA(), 0).edit();
            String str = C18559f.evO;
            if (SettingsRingtoneUI.this.qoD != 0) {
                Uri a = SettingsRingtoneUI.m77747a(SettingsRingtoneUI.this, SettingsRingtoneUI.this.qoD);
                C4990ab.m7410d("RingtonePickerActivity", "set ringtone to ".concat(String.valueOf(a)));
                if (a != null) {
                    str = a.toString();
                    String a2 = SettingsRingtoneUI.m77748a(SettingsRingtoneUI.this, a);
                    edit.putString("settings.ringtone.name", a2);
                    C4990ab.m7410d("RingtonePickerActivity", "ringtone name: ".concat(String.valueOf(a2)));
                } else {
                    str = C18559f.evO;
                    edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(C25738R.string.e9l));
                    C4990ab.m7410d("RingtonePickerActivity", "set ringtone follow system");
                }
            } else {
                str = C18559f.evO;
                edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(C25738R.string.e9l));
                C4990ab.m7410d("RingtonePickerActivity", "set ringtone follow system");
            }
            edit.commit();
            C18559f.m28903kA(str);
            SettingsRingtoneUI.this.finish();
            AppMethodBeat.m2505o(127425);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127430);
        super.onCreate(bundle);
        this.mHandler = new C7306ak();
        this.qoB = LayoutInflater.from(this);
        this.qoA = new RingtoneManager(this);
        this.qoA.setType(2);
        setVolumeControlStream(5);
        this.qoE = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        setMMTitle((int) C25738R.string.e9m);
        setBackBtn(new C348841());
        mo17379a(0, getString(C25738R.string.e7s), (OnMenuItemClickListener) new C396772(), C5535b.GREEN);
        ListView listView = (ListView) findViewById(2131827413);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.f17211PI = this.qoA.getCursor();
        listView.setAdapter(new C28958a(this.f17211PI));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String MK = C37885a.m63958MK();
        if (MK != C18559f.evO) {
            int ringtonePosition = this.qoA.getRingtonePosition(Uri.parse(MK));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.qoC = ringtonePosition;
            if (this.qoC == 1) {
                getSharedPreferences(C4996ah.doA(), 0).edit().putString("settings.ringtone.name", getString(C25738R.string.e9l)).commit();
                C4990ab.m7410d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.qoD = this.qoC - 1;
        } else {
            this.qoC = 1;
        }
        listView.setItemChecked(this.qoC, true);
        listView.setSelection(this.qoC);
        AppMethodBeat.m2505o(127430);
    }

    public final int getLayoutId() {
        return 2130970640;
    }

    public void run() {
        AppMethodBeat.m2504i(127432);
        if (isFinishing()) {
            AppMethodBeat.m2505o(127432);
            return;
        }
        Ringtone ringtone;
        if (this.qoD == 0) {
            ringtone = this.qoE;
        } else {
            ringtone = this.qoA.getRingtone(this.qoD - 1);
        }
        if (ringtone != null) {
            try {
                ringtone.play();
                AppMethodBeat.m2505o(127432);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(127432);
    }

    public void onStop() {
        AppMethodBeat.m2504i(127433);
        this.qoA.stopPreviousRingtone();
        super.onStop();
        AppMethodBeat.m2505o(127433);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127434);
        this.mHandler.removeCallbacks(this);
        if (!(this.f17211PI == null || this.f17211PI.isClosed())) {
            this.f17211PI.close();
            this.f17211PI = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(127434);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127435);
        boolean onKeyUp;
        if (i == 24 || i == 25) {
            onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.m2505o(127435);
            return onKeyUp;
        }
        onKeyUp = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127435);
        return onKeyUp;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(127431);
        this.mHandler.removeCallbacks(this);
        this.qoD = i - 1;
        this.mHandler.postDelayed(this, 300);
        AppMethodBeat.m2505o(127431);
    }
}
