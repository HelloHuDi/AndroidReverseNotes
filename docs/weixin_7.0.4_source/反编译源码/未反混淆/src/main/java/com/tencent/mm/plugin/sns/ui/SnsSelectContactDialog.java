package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> items = new LinkedList();
    private GridView rvo = null;
    private a rvp = null;

    static class b {
        ImageView image;
        ImageView rvr;

        b() {
        }
    }

    class a extends BaseAdapter {
        private Context context;
        private List<String> items;
        private int rgh = 0;
        private int type;

        public a(Context context, int i) {
            AppMethodBeat.i(39189);
            this.items = i;
            this.context = context;
            this.type = 0;
            refresh();
            AppMethodBeat.o(39189);
        }

        public final void refresh() {
            AppMethodBeat.i(39190);
            if (this.items == null) {
                this.rgh = 0;
            } else {
                this.rgh = this.items.size();
            }
            this.rgh++;
            notifyDataSetChanged();
            AppMethodBeat.o(39190);
        }

        public final int getCount() {
            return this.rgh;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(39191);
            Object obj = this.items.get(i);
            AppMethodBeat.o(39191);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View inflate;
            AppMethodBeat.i(39192);
            if (view == null) {
                bVar = new b();
                if (this.type == 0) {
                    inflate = View.inflate(this.context, R.layout.awy, null);
                } else {
                    inflate = View.inflate(this.context, R.layout.aur, null);
                }
                bVar.image = (ImageView) inflate.findViewById(R.id.bl);
                bVar.rvr = (ImageView) inflate.findViewById(R.id.egs);
                inflate.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                inflate = view;
            }
            inflate.setVisibility(0);
            if (i == this.rgh - 1) {
                bVar.image.setBackgroundDrawable(null);
                bVar.image.setImageResource(R.drawable.a0r);
                bVar.rvr.setVisibility(8);
                if (this.items.size() >= ab.xID) {
                    inflate.setVisibility(8);
                }
            } else {
                bVar.image.setBackgroundDrawable(null);
                bVar.rvr.setVisibility(0);
                if (this.type == 0) {
                    com.tencent.mm.pluginsdk.ui.a.b.b(bVar.image, (String) this.items.get(i));
                } else {
                    bVar.image.setImageBitmap(d.d((String) this.items.get(i), af.cnN(), af.cnN(), true));
                }
            }
            bVar.image.setScaleType(ScaleType.CENTER_CROP);
            AppMethodBeat.o(39192);
            return inflate;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSelectContactDialog() {
        AppMethodBeat.i(39193);
        AppMethodBeat.o(39193);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39194);
        super.onCreate(bundle);
        setContentView(R.layout.auw);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.items.clear();
        } else {
            this.items = bo.P(stringExtra.split(","));
        }
        this.rvo = (GridView) findViewById(R.id.eh8);
        this.rvp = new a(this, this.items);
        this.rvo.setAdapter(this.rvp);
        this.rvo.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(39187);
                if (i == SnsSelectContactDialog.this.rvp.getCount() - 1) {
                    SnsSelectContactDialog.b(SnsSelectContactDialog.this);
                } else {
                    SnsSelectContactDialog.this.items.remove(i);
                }
                SnsSelectContactDialog.this.rvp.refresh();
                AppMethodBeat.o(39187);
            }
        });
        this.rvo.setSelection(this.rvp.getCount() - 1);
        ((ImageButton) findViewById(R.id.eh9)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39188);
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", bo.c(SnsSelectContactDialog.this.items, ","));
                SnsSelectContactDialog.this.setResult(-1, intent);
                SnsSelectContactDialog.this.finish();
                AppMethodBeat.o(39188);
            }
        });
        AppMethodBeat.o(39194);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(39195);
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", bo.c(this.items, ","));
            setResult(-1, intent);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(39195);
        return onKeyDown;
    }

    private boolean ZG(String str) {
        AppMethodBeat.i(39196);
        for (Object equals : t.fkY) {
            if (str.equals(equals)) {
                AppMethodBeat.o(39196);
                return false;
            }
        }
        if (t.kH(str)) {
            AppMethodBeat.o(39196);
            return false;
        } else if (t.mZ(str)) {
            AppMethodBeat.o(39196);
            return false;
        } else if (this.items == null || !this.items.contains(str)) {
            AppMethodBeat.o(39196);
            return true;
        } else {
            AppMethodBeat.o(39196);
            return false;
        }
    }

    private String ctJ() {
        AppMethodBeat.i(39197);
        be XR = ((j) g.K(j.class)).XR();
        String str = t.fkP;
        LinkedList linkedList = new LinkedList();
        for (Object add : t.fkY) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor c = XR.c(str, linkedList, "*");
        String str2;
        if (c.getCount() == 0) {
            c.close();
            str2 = "";
            AppMethodBeat.o(39197);
            return str2;
        }
        List linkedList2 = new LinkedList();
        c.moveToFirst();
        do {
            ak akVar = new ak();
            akVar.d(c);
            if (ZG(akVar.field_username)) {
                linkedList2.add(akVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (c.moveToNext());
        c.close();
        str2 = bo.c(linkedList2, ";");
        AppMethodBeat.o(39197);
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39198);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(39198);
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    ArrayList<String> P = bo.P(intent.getStringExtra("Select_Contact").split(","));
                    if (P != null) {
                        if (this.items == null) {
                            this.items = new LinkedList();
                        }
                        for (String str : P) {
                            if (!this.items.contains(str)) {
                                this.items.add(str);
                            }
                        }
                        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.items.size());
                        if (this.rvp != null) {
                            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                            this.rvp.refresh();
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Select_Contact", bo.c(this.items, ","));
                        setResult(-1, intent2);
                        finish();
                        break;
                    }
                    AppMethodBeat.o(39198);
                    return;
                }
                AppMethodBeat.o(39198);
                return;
        }
        AppMethodBeat.o(39198);
    }

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        AppMethodBeat.i(39199);
        Intent intent = new Intent();
        String str = bo.c(snsSelectContactDialog.items, ",") + ", " + r.Yz();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.ctJ());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(R.string.eu));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.items.size());
        com.tencent.mm.plugin.sns.c.a.gkE.a(intent, (Activity) snsSelectContactDialog, 1);
        AppMethodBeat.o(39199);
    }
}
