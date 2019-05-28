package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    private Cursor PI;
    private ak mHandler;
    private RingtoneManager qoA;
    LayoutInflater qoB;
    private int qoC = -1;
    private int qoD = -1;
    private Ringtone qoE;

    class a extends BaseAdapter {
        int count = 0;
        Cursor cyz;
        int padding = 0;

        public a(Cursor cursor) {
            AppMethodBeat.i(127426);
            this.cyz = cursor;
            this.count = cursor.getCount() + 1;
            ab.d("RingtonePickerActivity", "count = " + this.count);
            this.padding = SettingsRingtoneUI.this.getResources().getDimensionPixelSize(R.dimen.m4);
            AppMethodBeat.o(127426);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(127427);
            CheckedTextView checkedTextView = (CheckedTextView) SettingsRingtoneUI.this.qoB.inflate(R.layout.aqm, null);
            if (i == 0) {
                checkedTextView.setBackgroundResource(R.drawable.k5);
                checkedTextView.setText(R.string.e9l);
            } else {
                checkedTextView.setBackgroundResource(R.drawable.k5);
                checkedTextView.setText(getItem(i));
            }
            checkedTextView.setPadding(this.padding, 0, this.padding, 0);
            checkedTextView.setCheckMarkDrawable(R.drawable.yu);
            AppMethodBeat.o(127427);
            return checkedTextView;
        }

        public final int getCount() {
            return this.count;
        }

        private String getItem(int i) {
            AppMethodBeat.i(127428);
            String str;
            if (this.cyz.isClosed() || !this.cyz.moveToPosition(i - 1)) {
                str = "";
                AppMethodBeat.o(127428);
                return str;
            }
            str = this.cyz.getString(this.cyz.getColumnIndex("title"));
            AppMethodBeat.o(127428);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127430);
        super.onCreate(bundle);
        this.mHandler = new ak();
        this.qoB = LayoutInflater.from(this);
        this.qoA = new RingtoneManager(this);
        this.qoA.setType(2);
        setVolumeControlStream(5);
        this.qoE = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        setMMTitle((int) R.string.e9m);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127424);
                SettingsRingtoneUI.this.aqX();
                SettingsRingtoneUI.this.finish();
                AppMethodBeat.o(127424);
                return true;
            }
        });
        a(0, getString(R.string.e7s), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127425);
                Editor edit = SettingsRingtoneUI.this.getSharedPreferences(ah.doA(), 0).edit();
                String str = f.evO;
                if (SettingsRingtoneUI.this.qoD != 0) {
                    Uri a = SettingsRingtoneUI.a(SettingsRingtoneUI.this, SettingsRingtoneUI.this.qoD);
                    ab.d("RingtonePickerActivity", "set ringtone to ".concat(String.valueOf(a)));
                    if (a != null) {
                        str = a.toString();
                        String a2 = SettingsRingtoneUI.a(SettingsRingtoneUI.this, a);
                        edit.putString("settings.ringtone.name", a2);
                        ab.d("RingtonePickerActivity", "ringtone name: ".concat(String.valueOf(a2)));
                    } else {
                        str = f.evO;
                        edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(R.string.e9l));
                        ab.d("RingtonePickerActivity", "set ringtone follow system");
                    }
                } else {
                    str = f.evO;
                    edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(R.string.e9l));
                    ab.d("RingtonePickerActivity", "set ringtone follow system");
                }
                edit.commit();
                f.kA(str);
                SettingsRingtoneUI.this.finish();
                AppMethodBeat.o(127425);
                return true;
            }
        }, b.GREEN);
        ListView listView = (ListView) findViewById(R.id.e_o);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.l5);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.PI = this.qoA.getCursor();
        listView.setAdapter(new a(this.PI));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String MK = com.tencent.mm.m.a.MK();
        if (MK != f.evO) {
            int ringtonePosition = this.qoA.getRingtonePosition(Uri.parse(MK));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.qoC = ringtonePosition;
            if (this.qoC == 1) {
                getSharedPreferences(ah.doA(), 0).edit().putString("settings.ringtone.name", getString(R.string.e9l)).commit();
                ab.d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.qoD = this.qoC - 1;
        } else {
            this.qoC = 1;
        }
        listView.setItemChecked(this.qoC, true);
        listView.setSelection(this.qoC);
        AppMethodBeat.o(127430);
    }

    public final int getLayoutId() {
        return R.layout.ary;
    }

    public void run() {
        AppMethodBeat.i(127432);
        if (isFinishing()) {
            AppMethodBeat.o(127432);
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
                AppMethodBeat.o(127432);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
            }
        }
        AppMethodBeat.o(127432);
    }

    public void onStop() {
        AppMethodBeat.i(127433);
        this.qoA.stopPreviousRingtone();
        super.onStop();
        AppMethodBeat.o(127433);
    }

    public void onDestroy() {
        AppMethodBeat.i(127434);
        this.mHandler.removeCallbacks(this);
        if (!(this.PI == null || this.PI.isClosed())) {
            this.PI.close();
            this.PI = null;
        }
        super.onDestroy();
        AppMethodBeat.o(127434);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127435);
        boolean onKeyUp;
        if (i == 24 || i == 25) {
            onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.o(127435);
            return onKeyUp;
        }
        onKeyUp = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127435);
        return onKeyUp;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(127431);
        this.mHandler.removeCallbacks(this);
        this.qoD = i - 1;
        this.mHandler.postDelayed(this, 300);
        AppMethodBeat.o(127431);
    }
}
