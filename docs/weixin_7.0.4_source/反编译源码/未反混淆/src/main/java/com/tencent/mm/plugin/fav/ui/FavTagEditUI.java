package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FavTagEditUI extends MMActivity {
    private g mjP;
    private List<String> mjQ;
    private FavTagPanel mjR;
    private FavTagPanel mjS;
    private ListView mjT;
    private ListView mjU;
    private TextView mjV;
    private c mjW;
    private d mjX;
    private boolean mjY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FavTagEditUI favTagEditUI) {
        AppMethodBeat.i(74159);
        favTagEditUI.bvO();
        AppMethodBeat.o(74159);
    }

    static /* synthetic */ void c(FavTagEditUI favTagEditUI) {
        AppMethodBeat.i(74160);
        favTagEditUI.bvN();
        AppMethodBeat.o(74160);
    }

    public final int getLayoutId() {
        return R.layout.yx;
    }

    public void onCreate(Bundle bundle) {
        List list;
        AppMethodBeat.i(74153);
        super.onCreate(bundle);
        final long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.mjP = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(longExtra);
        }
        this.mjQ = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.mjS = (FavTagPanel) findViewById(R.id.brh);
        this.mjT = (ListView) findViewById(R.id.brj);
        this.mjU = (ListView) findViewById(R.id.bro);
        this.mjV = (TextView) findViewById(R.id.brn);
        this.mjS.qe(true);
        this.mjS.setTagEditTextBG(R.drawable.a2s);
        this.mjS.setIsAllowEnterCharacter(true);
        this.mjS.setCallBack(new a() {
            public final void JR(String str) {
                AppMethodBeat.i(74141);
                FavTagEditUI.this.mjS.removeTag(str);
                FavTagEditUI.this.mjW.Mf(str);
                if (FavTagEditUI.this.mjR != null) {
                    FavTagEditUI.this.mjR.cd(str, false);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74141);
            }

            public final void JS(String str) {
            }

            public final void JT(String str) {
                AppMethodBeat.i(74142);
                FavTagEditUI.this.mjS.removeTag(str);
                FavTagEditUI.this.mjW.Mf(str);
                if (FavTagEditUI.this.mjR != null) {
                    FavTagEditUI.this.mjR.cd(str, false);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74142);
            }

            public final void JU(String str) {
                AppMethodBeat.i(74143);
                if (bo.isNullOrNil(str)) {
                    FavTagEditUI.this.mjU.setVisibility(8);
                    FavTagEditUI.this.mjT.setVisibility(0);
                } else {
                    d h = FavTagEditUI.this.mjX;
                    h.mly.clear();
                    h.mlx.clear();
                    h.kPJ = bo.bc(str, "");
                    l favTagSetMgr = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr();
                    boolean isNullOrNil = bo.isNullOrNil(str);
                    ArrayList arrayList = new ArrayList(16);
                    Iterator it = favTagSetMgr.mfn.wiH.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((abq) it.next()).wiG.iterator();
                        while (it2.hasNext()) {
                            abp abp = (abp) it2.next();
                            if (isNullOrNil || abp.rMJ.contains(str)) {
                                arrayList.add(abp.rMJ);
                            }
                        }
                    }
                    h.mlx.addAll(arrayList);
                    h.notifyDataSetChanged();
                    FavTagEditUI.this.mjU.setVisibility(0);
                    FavTagEditUI.this.mjT.setVisibility(8);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74143);
            }

            public final void JV(String str) {
                AppMethodBeat.i(74144);
                if (bo.isNullOrNil(str)) {
                    ab.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
                    AppMethodBeat.o(74144);
                    return;
                }
                FavTagEditUI.this.mjS.cc(str, true);
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74144);
            }

            public final void bmm() {
            }

            public final void q(boolean z, int i) {
                AppMethodBeat.i(74145);
                FavTagEditUI.this.mjY = z;
                TextView k = FavTagEditUI.this.mjV;
                int i2 = (!FavTagEditUI.this.mjY || i <= 0) ? 8 : 0;
                k.setVisibility(i2);
                FavTagEditUI.this.mjV.setText(FavTagEditUI.this.getString(R.string.bs1, new Object[]{Integer.valueOf(i)}));
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74145);
            }
        });
        this.mjS.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74146);
                FavTagEditUI.this.mjS.dAc();
                FavTagEditUI.this.showVKB();
                AppMethodBeat.o(74146);
            }
        }, 100);
        if (this.mjP != null) {
            this.mjS.a((Collection) this.mjP.field_tagProto.wiJ, (List) this.mjP.field_tagProto.wiJ);
        } else if (this.mjQ != null) {
            this.mjS.a((Collection) this.mjQ, this.mjQ);
        }
        this.mjW = new c(this.mController.ylL) {
            public final void Ma(String str) {
                AppMethodBeat.i(74147);
                FavTagEditUI.this.mjS.cc(str, true);
                if (FavTagEditUI.this.mjR != null) {
                    FavTagEditUI.this.mjR.cd(str, true);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74147);
            }

            public final void Mb(String str) {
                AppMethodBeat.i(74148);
                FavTagEditUI.this.mjS.removeTag(str);
                if (FavTagEditUI.this.mjR != null) {
                    FavTagEditUI.this.mjR.cd(str, false);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74148);
            }
        };
        c cVar = this.mjW;
        if (this.mjP == null) {
            list = null;
        } else {
            list = this.mjP.field_tagProto.wiJ;
        }
        cVar.bQ(list);
        if (!(this.mjP == null || this.mjP.field_tagProto.wiI.isEmpty())) {
            View inflate = View.inflate(this.mController.ylL, R.layout.z1, null);
            TextView textView = (TextView) inflate.findViewById(R.id.brt);
            textView.setText(getString(R.string.bqe));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.i4);
            this.mjR = (FavTagPanel) inflate.findViewById(R.id.bru);
            this.mjR.setVisibility(0);
            this.mjR.a((Collection) this.mjP.field_tagProto.wiJ, (List) this.mjP.field_tagProto.wiI);
            this.mjR.setBackgroundResource(R.drawable.a_r);
            this.mjR.setPadding(0, 0, 0, dimensionPixelSize);
            this.mjR.setCallBack(new a() {
                public final void JR(String str) {
                    AppMethodBeat.i(74149);
                    FavTagEditUI.this.mjS.removeTag(str);
                    FavTagEditUI.this.mjW.Mf(str);
                    FavTagEditUI.c(FavTagEditUI.this);
                    AppMethodBeat.o(74149);
                }

                public final void JS(String str) {
                    AppMethodBeat.i(74150);
                    FavTagEditUI.this.mjS.cc(str, true);
                    FavTagEditUI.this.mjW.Me(str);
                    FavTagEditUI.c(FavTagEditUI.this);
                    AppMethodBeat.o(74150);
                }

                public final void JT(String str) {
                }

                public final void bmm() {
                }

                public final void JU(String str) {
                }

                public final void JV(String str) {
                }

                public final void q(boolean z, int i) {
                }
            });
            this.mjT.addHeaderView(inflate);
        }
        if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().buE() > 0) {
            this.mjT.addHeaderView(View.inflate(this.mController.ylL, R.layout.z0, null));
        }
        this.mjT.setAdapter(this.mjW);
        this.mjT.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74151);
                FavTagEditUI.this.mjS.dAd();
                AppMethodBeat.o(74151);
                return false;
            }
        });
        this.mjX = new d(this.mController.ylL) {
            public final void KI(String str) {
                AppMethodBeat.i(74152);
                FavTagEditUI.this.mjS.cc(str, true);
                FavTagEditUI.this.mjW.Me(str);
                FavTagEditUI.this.mjS.dAb();
                FavTagEditUI.this.mjS.dAd();
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(74152);
            }
        };
        this.mjU.setAdapter(this.mjX);
        this.mjU.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74138);
                FavTagEditUI.this.mjS.dAd();
                AppMethodBeat.o(74138);
                return false;
            }
        });
        setMMTitle((int) R.string.bo8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74137);
                FavTagEditUI.a(FavTagEditUI.this);
                AppMethodBeat.o(74137);
                return true;
            }
        });
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74139);
                if (FavTagEditUI.this.mjY) {
                    FavTagEditUI.c(FavTagEditUI.this);
                    AppMethodBeat.o(74139);
                } else {
                    ArrayList tagList = FavTagEditUI.this.mjS.getTagList();
                    String trim = FavTagEditUI.this.mjS.getEditText().trim();
                    if (!bo.isNullOrNil(trim)) {
                        tagList.remove(trim);
                        tagList.add(trim);
                    }
                    FavTagEditUI.this.mjP = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(longExtra);
                    Intent intent;
                    if (FavTagEditUI.this.mjP != null) {
                        FavTagEditUI.a(FavTagEditUI.this.mjP, tagList, FavTagEditUI.this.getIntent().getIntExtra("key_fav_scene", 1));
                        intent = new Intent();
                        intent.putExtra("key_fav_result_list", tagList);
                        FavTagEditUI.this.setResult(-1, intent);
                    } else {
                        String[] strArr = new String[tagList.size()];
                        Iterator it = tagList.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            int i2 = i + 1;
                            strArr[i] = (String) it.next();
                            i = i2;
                        }
                        intent = new Intent();
                        intent.putExtra("key_fav_result_array", strArr);
                        intent.putExtra("key_fav_result_list", tagList);
                        FavTagEditUI.this.setResult(-1, intent);
                    }
                    FavTagEditUI.this.finish();
                    FavTagEditUI.this.aqX();
                    AppMethodBeat.o(74139);
                }
                return true;
            }
        }, b.GREEN);
        bvN();
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().a(this.mjW);
        AppMethodBeat.o(74153);
    }

    private void bvN() {
        AppMethodBeat.i(74154);
        if (this.mjY) {
            ab.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (dxX()) {
                enableOptionMenu(0, false);
            }
            AppMethodBeat.o(74154);
            return;
        }
        if (this.mjP == null) {
            if (this.mjS.getTagCount() > 0 || this.mjS.getEditText().length() > 0) {
                if (!dxX()) {
                    enableOptionMenu(0, true);
                    AppMethodBeat.o(74154);
                    return;
                }
            } else if (dxX()) {
                enableOptionMenu(0, false);
                AppMethodBeat.o(74154);
                return;
            }
        } else if (this.mjP.field_tagProto.wiJ.size() == this.mjS.getTagCount() && this.mjS.getEditText().length() <= 0) {
            ArrayList tagList = this.mjS.getTagList();
            int i = 0;
            while (i < tagList.size()) {
                if (((String) tagList.get(i)).equals(this.mjP.field_tagProto.wiJ.get(i))) {
                    i++;
                } else {
                    if (!dxX()) {
                        enableOptionMenu(0, true);
                    }
                    AppMethodBeat.o(74154);
                    return;
                }
            }
            if (dxX()) {
                enableOptionMenu(0, false);
            }
        } else if (!dxX()) {
            enableOptionMenu(0, true);
            AppMethodBeat.o(74154);
            return;
        }
        AppMethodBeat.o(74154);
    }

    public void onDestroy() {
        AppMethodBeat.i(74155);
        super.onDestroy();
        l favTagSetMgr = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr();
        c cVar = this.mjW;
        if (cVar == null) {
            AppMethodBeat.o(74155);
            return;
        }
        favTagSetMgr.fBy.remove(cVar.toString());
        AppMethodBeat.o(74155);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(74156);
        if (i == 4) {
            bvO();
            AppMethodBeat.o(74156);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(74156);
        return onKeyDown;
    }

    public static void a(g gVar, Collection<String> collection, int i) {
        AppMethodBeat.i(74158);
        if (gVar == null) {
            AppMethodBeat.o(74158);
            return;
        }
        Set set;
        ab.d("MicroMsg.FavTagEditUI", "mod tags %s", collection);
        HashSet hashSet = new HashSet();
        hashSet.addAll(gVar.field_tagProto.wiJ);
        gVar.field_tagProto.wiJ.clear();
        if (collection == null || collection.isEmpty()) {
            set = hashSet;
        } else {
            gVar.field_tagProto.wiJ.addAll(collection);
            hashSet.removeAll(collection);
            Object set2 = hashSet;
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
        com.tencent.mm.plugin.fav.a.b.p(gVar);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavTagSetMgr().e(set2);
        com.tencent.mm.plugin.fav.a.b.a(gVar, i);
        AppMethodBeat.o(74158);
    }

    private void bvO() {
        AppMethodBeat.i(74157);
        h.d(this.mController.ylL, getString(R.string.bqd), "", getString(R.string.fx), getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(74140);
                FavTagEditUI.this.finish();
                AppMethodBeat.o(74140);
            }
        }, null);
        AppMethodBeat.o(74157);
    }
}
