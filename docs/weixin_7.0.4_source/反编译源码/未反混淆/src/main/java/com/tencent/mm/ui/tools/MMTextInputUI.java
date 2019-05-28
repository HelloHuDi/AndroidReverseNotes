package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;

public class MMTextInputUI extends MMActivity {
    private int ehD;
    private EditText mLL;
    private TextView zGb;
    private int zGc;
    private int zGd;
    private boolean zGe;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MMTextInputUI mMTextInputUI) {
        AppMethodBeat.i(107734);
        mMTextInputUI.goBack();
        AppMethodBeat.o(107734);
    }

    public int getLayoutId() {
        return R.layout.a81;
    }

    private void goBack() {
        AppMethodBeat.i(107728);
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            h.a(this.mController.ylL, getString(R.string.dgt), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(107724);
                    MMTextInputUI.this.aqX();
                    MMTextInputUI.this.setResult(0);
                    MMTextInputUI.this.finish();
                    AppMethodBeat.o(107724);
                }
            }, null);
            AppMethodBeat.o(107728);
            return;
        }
        aqX();
        setResult(0);
        finish();
        AppMethodBeat.o(107728);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(107729);
        if (4 == i) {
            ab.i("MicroMsg.MMTextInputUI", "on back key down");
            goBack();
            AppMethodBeat.o(107729);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(107729);
        return onKeyDown;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107730);
        super.onCreate(bundle);
        this.mLL = (EditText) findViewById(R.id.bbt);
        this.zGb = (TextView) findViewById(R.id.bph);
        this.mLL.setHint(bo.bc(getIntent().getStringExtra("key_hint"), ""));
        this.mLL.append(bo.bc(getIntent().getStringExtra("key_value"), ""));
        this.ehD = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.zGd = 0;
        this.zGc = Math.max(this.ehD - 120, (this.ehD * 9) / 10);
        this.zGe = getIntent().getBooleanExtra("key_nullable", false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107725);
                MMTextInputUI.a(MMTextInputUI.this);
                AppMethodBeat.o(107725);
                return false;
            }
        });
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107726);
                MMTextInputUI.this.I(MMTextInputUI.this.mLL.getText());
                Intent intent = new Intent();
                intent.putExtra("key_result", MMTextInputUI.this.mLL.getText());
                MMTextInputUI.this.setResult(-1, intent);
                MMTextInputUI.this.finish();
                AppMethodBeat.o(107726);
                return true;
            }
        }, b.GREEN);
        enableOptionMenu(this.zGe);
        if (!this.zGe || this.ehD > 0) {
            this.mLL.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    boolean z = false;
                    AppMethodBeat.i(107727);
                    String obj = editable.toString();
                    if (!MMTextInputUI.this.zGe) {
                        if (obj.trim().length() > 0) {
                            MMTextInputUI.this.enableOptionMenu(true);
                        } else {
                            MMTextInputUI.this.enableOptionMenu(false);
                        }
                    }
                    if (MMTextInputUI.this.ehD > 0) {
                        MMTextInputUI.this.zGd = 0;
                        for (int i = 0; i < obj.length(); i++) {
                            if (bo.y(obj.charAt(i))) {
                                MMTextInputUI.this.zGd = MMTextInputUI.this.zGd + 2;
                            } else {
                                MMTextInputUI.this.zGd = MMTextInputUI.this.zGd + 1;
                            }
                        }
                        if (MMTextInputUI.this.zGd >= MMTextInputUI.this.zGc && MMTextInputUI.this.zGd <= MMTextInputUI.this.ehD) {
                            MMTextInputUI.this.enableOptionMenu(true);
                            MMTextInputUI.this.zGb.setVisibility(0);
                            MMTextInputUI.this.zGb.setTextColor(MMTextInputUI.this.getResources().getColor(R.color.a2x));
                            MMTextInputUI.this.zGb.setText(MMTextInputUI.this.getString(R.string.evr, new Object[]{Integer.valueOf((MMTextInputUI.this.ehD - MMTextInputUI.this.zGd) >> 1)}));
                            AppMethodBeat.o(107727);
                            return;
                        } else if (MMTextInputUI.this.zGd > MMTextInputUI.this.ehD) {
                            MMTextInputUI.this.enableOptionMenu(false);
                            MMTextInputUI.this.zGb.setVisibility(0);
                            MMTextInputUI.this.zGb.setTextColor(MMTextInputUI.this.getResources().getColor(R.color.a2y));
                            MMTextInputUI.this.zGb.setText(MMTextInputUI.this.getString(R.string.evs, new Object[]{Integer.valueOf(((MMTextInputUI.this.zGd - MMTextInputUI.this.ehD) >> 1) + 1)}));
                            AppMethodBeat.o(107727);
                            return;
                        } else {
                            MMTextInputUI mMTextInputUI = MMTextInputUI.this;
                            if (MMTextInputUI.this.zGe) {
                                z = true;
                            } else if (MMTextInputUI.this.zGd > 0) {
                                z = true;
                            }
                            mMTextInputUI.enableOptionMenu(z);
                            MMTextInputUI.this.zGb.setVisibility(8);
                        }
                    }
                    AppMethodBeat.o(107727);
                }
            });
        }
        AppMethodBeat.o(107730);
    }

    /* Access modifiers changed, original: protected */
    public void I(CharSequence charSequence) {
    }

    public void onDestroy() {
        AppMethodBeat.i(107731);
        super.onDestroy();
        AppMethodBeat.o(107731);
    }

    public void onResume() {
        AppMethodBeat.i(107732);
        super.onResume();
        AppMethodBeat.o(107732);
    }

    public void onPause() {
        AppMethodBeat.i(107733);
        super.onPause();
        AppMethodBeat.o(107733);
    }
}
