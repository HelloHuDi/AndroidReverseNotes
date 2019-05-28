package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.ttpic.util.ActUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements f {
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(24001);
            ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
            if (z) {
                Location location = new Location(f2, f, (int) d2, i, "", "");
                if (!location.dhR()) {
                    FacingCreateChatRoomAllInOneUI.this.pqT = location;
                    FacingCreateChatRoomAllInOneUI.this.pqQ = true;
                    FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
                }
            } else {
                if (!(FacingCreateChatRoomAllInOneUI.this.nPX || d.agA())) {
                    FacingCreateChatRoomAllInOneUI.this.nPX = true;
                    h.a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(R.string.c9z), FacingCreateChatRoomAllInOneUI.this.getString(R.string.tz), FacingCreateChatRoomAllInOneUI.this.getString(R.string.ckr), FacingCreateChatRoomAllInOneUI.this.getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24000);
                            d.bX(FacingCreateChatRoomAllInOneUI.this);
                            AppMethodBeat.o(24000);
                        }
                    }, null);
                }
                FacingCreateChatRoomAllInOneUI.this.pqQ = false;
            }
            AppMethodBeat.o(24001);
            return false;
        }
    };
    private String elr;
    private ProgressDialog gqo;
    private boolean jIN = false;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(23993);
            switch (message.what) {
                case 10001:
                    if (FacingCreateChatRoomAllInOneUI.this.prg != null) {
                        FacingCreateChatRoomAllInOneUI.this.prg.setData(FacingCreateChatRoomAllInOneUI.this.prd);
                        AppMethodBeat.o(23993);
                        return;
                    }
                    break;
                case 10002:
                    FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
                    break;
            }
            AppMethodBeat.o(23993);
        }
    };
    private boolean nPX;
    private d pqN;
    private boolean pqO = false;
    private boolean pqP;
    private boolean pqQ;
    private boolean pqR;
    private boolean pqS = false;
    private Location pqT;
    private String pqU;
    private MMPwdInputView pqV;
    private View pqW;
    private ProgressBar pqX;
    private TextView pqY;
    private MMKeyBoardView pqZ;
    private View.OnClickListener prA = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(23996);
            FacingCreateChatRoomAllInOneUI.this.prb = false;
            FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
            AppMethodBeat.o(23996);
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a prB = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a() {
        public final void input(String str) {
            AppMethodBeat.i(23997);
            if (FacingCreateChatRoomAllInOneUI.this.pqV != null) {
                if (FacingCreateChatRoomAllInOneUI.this.pqO || FacingCreateChatRoomAllInOneUI.this.pqS) {
                    MMPwdInputView g = FacingCreateChatRoomAllInOneUI.this.pqV;
                    g.axQ();
                    g.input(str);
                    FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, a.Normal);
                    AppMethodBeat.o(23997);
                    return;
                }
                FacingCreateChatRoomAllInOneUI.this.pqV.input(str);
            }
            AppMethodBeat.o(23997);
        }

        public final void axQ() {
            AppMethodBeat.i(23998);
            if (FacingCreateChatRoomAllInOneUI.this.pqV != null) {
                FacingCreateChatRoomAllInOneUI.this.pqV.axQ();
            }
            AppMethodBeat.o(23998);
        }

        public final void delete() {
            AppMethodBeat.i(23999);
            if (FacingCreateChatRoomAllInOneUI.this.pqV != null) {
                if (FacingCreateChatRoomAllInOneUI.this.pqO || FacingCreateChatRoomAllInOneUI.this.pqS) {
                    FacingCreateChatRoomAllInOneUI.this.pqV.axQ();
                    FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, a.Normal);
                    AppMethodBeat.o(23999);
                    return;
                }
                MMPwdInputView g = FacingCreateChatRoomAllInOneUI.this.pqV;
                if (g.mbi > 0) {
                    g.enD.deleteCharAt(g.mbi - 1);
                }
                g.btM();
                g.cbX();
            }
            AppMethodBeat.o(23999);
        }
    };
    private ap prC = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(24002);
            FacingCreateChatRoomAllInOneUI.this.pqP = false;
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, a.Unknow);
            AppMethodBeat.o(24002);
            return true;
        }
    }, false);
    private TextView pra;
    private boolean prb = false;
    private boolean prc = false;
    private LinkedList<aan> prd = new LinkedList();
    private HashMap<String, aan> pre = new HashMap();
    private LinkedList<aan> prf = new LinkedList();
    private a prg;
    private View prh;
    private TextView pri;
    private MMScrollGridView prj;
    private View prk;
    private View prl;
    private Button prm;
    private MMCallBackScrollView prn;
    private TextView pro;
    private boolean prp = false;
    private al prq = new al();
    private ap prr = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(23983);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this);
            AppMethodBeat.o(23983);
            return false;
        }
    }, false);
    private com.tencent.mm.plugin.pwdgroup.a.a prs;
    private com.tencent.mm.plugin.pwdgroup.a.a prt;
    private int pru;
    private Animation prv;
    private AnimationSet prw;
    private Animation prx;
    public OnMenuItemClickListener pry = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(23994);
            FacingCreateChatRoomAllInOneUI.this.finish();
            AppMethodBeat.o(23994);
            return false;
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a prz = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a() {
        public final void o(boolean z, String str) {
            AppMethodBeat.i(23995);
            ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", Boolean.valueOf(z), str);
            FacingCreateChatRoomAllInOneUI.this.pqU = str;
            if (z) {
                FacingCreateChatRoomAllInOneUI.this.pqP = true;
                FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
            }
            AppMethodBeat.o(23995);
        }
    };

    enum a {
        Normal,
        Loading,
        ToSimple,
        Unknow;

        static {
            AppMethodBeat.o(24006);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FacingCreateChatRoomAllInOneUI() {
        AppMethodBeat.i(24007);
        AppMethodBeat.o(24007);
    }

    public final int getLayoutId() {
        return R.layout.xx;
    }

    private void aps() {
        AppMethodBeat.i(24009);
        this.pqN = d.agz();
        this.pqN.a(this.ecy, true);
        aw.Rg().a(653, (f) this);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        initView();
        AppMethodBeat.o(24009);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(24010);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(24010);
            return;
        }
        ab.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24003);
                            FacingCreateChatRoomAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FacingCreateChatRoomAllInOneUI.this.finish();
                            AppMethodBeat.o(24003);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23984);
                            FacingCreateChatRoomAllInOneUI.this.finish();
                            AppMethodBeat.o(23984);
                        }
                    });
                    break;
                }
                aps();
                AppMethodBeat.o(24010);
                return;
        }
        AppMethodBeat.o(24010);
    }

    public void onResume() {
        AppMethodBeat.i(24011);
        if (this.pqN != null) {
            this.pqN.a(this.ecy, true);
        }
        if (this.prp) {
            cbT();
        }
        super.onResume();
        AppMethodBeat.o(24011);
    }

    public void onPause() {
        AppMethodBeat.i(24012);
        if (this.pqN != null) {
            this.pqN.c(this.ecy);
        }
        if (this.prp) {
            cbU();
        }
        super.onPause();
        AppMethodBeat.o(24012);
    }

    public void onDestroy() {
        AppMethodBeat.i(24013);
        aw.Rg().b(653, (f) this);
        if (this.pqN != null) {
            this.pqN.c(this.ecy);
        }
        if (!this.prc) {
            aw.Rg().cancel(653);
            if (this.pqT != null) {
                this.prt = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.pqU, "", this.pqT.fBr, this.pqT.fBs, this.pqT.accuracy, this.pqT.cGo, this.pqT.mac, this.pqT.cGq);
                aw.Rg().a(this.prt, 0);
            }
        }
        if (this.prp) {
            cbU();
        }
        super.onDestroy();
        AppMethodBeat.o(24013);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(24014);
        super.onActivityResult(i, i2, intent);
        if (i == 30764) {
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    finish();
                    AppMethodBeat.o(24014);
                    return;
                }
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                AppMethodBeat.o(24014);
                return;
            }
            finish();
        }
        AppMethodBeat.o(24014);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.i(24015);
        setMMTitle((int) R.string.bts);
        setBackBtn(this.pry);
        xE(getResources().getColor(R.color.a3p));
        this.pqW = findViewById(R.id.box);
        this.pqX = (ProgressBar) findViewById(R.id.boy);
        this.pqY = (TextView) findViewById(R.id.boz);
        this.pqZ = (MMKeyBoardView) findViewById(R.id.bp0);
        this.pra = (TextView) findViewById(R.id.bop);
        this.pqV = (MMPwdInputView) findViewById(R.id.bot);
        this.pqV.setOnFinishInputListener(this.prz);
        this.pqV.requestFocus();
        this.pqZ.setOnInputDeleteListener(this.prB);
        a(a.Normal);
        this.prh = findViewById(R.id.bou);
        this.pri = (TextView) findViewById(R.id.bov);
        this.prj = (MMScrollGridView) findViewById(R.id.bow);
        this.prj.setVisibility(4);
        this.prm = (Button) findViewById(R.id.bp2);
        this.prm.setOnClickListener(this.prA);
        this.prk = findViewById(R.id.bor);
        this.prl = findViewById(R.id.bp1);
        this.pri.setText(R.string.bmz);
        this.prn = (MMCallBackScrollView) findViewById(R.id.boq);
        this.pro = (TextView) findViewById(R.id.bos);
        this.prn.setMMOnScrollListener(new com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a() {
            public final void cm(int i) {
                AppMethodBeat.i(23985);
                if (FacingCreateChatRoomAllInOneUI.this.prl != null) {
                    if (i == 0) {
                        FacingCreateChatRoomAllInOneUI.this.prl.setVisibility(4);
                        AppMethodBeat.o(23985);
                        return;
                    }
                    FacingCreateChatRoomAllInOneUI.this.prl.setVisibility(0);
                }
                AppMethodBeat.o(23985);
            }
        });
        this.prg = new a(this);
        this.prj.setAdapter(this.prg);
        this.prg.setData(this.prd);
        AppMethodBeat.o(24015);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(24016);
        ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (mVar.getType()) {
            case 653:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) mVar;
                int i3 = aVar.czW;
                if (i3 == 0) {
                    this.pqR = false;
                    if (this.prp) {
                        if (this.prr != null) {
                            this.prr.ae(3000, 3000);
                        }
                        if (i == 0 && i2 == 0) {
                            final LinkedList linkedList = aVar.cbS().vEh;
                            this.prq.aa(new Runnable() {
                                public final void run() {
                                    int size;
                                    int i;
                                    aan aan;
                                    AppMethodBeat.i(23989);
                                    if (FacingCreateChatRoomAllInOneUI.this.prf != null) {
                                        FacingCreateChatRoomAllInOneUI.this.prf.clear();
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.pre != null) {
                                        FacingCreateChatRoomAllInOneUI.this.pre.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        size = linkedList.size();
                                        for (i = 0; i < size; i++) {
                                            aan = (aan) linkedList.get(i);
                                            if (!bo.isNullOrNil(aan.wfK)) {
                                                FacingCreateChatRoomAllInOneUI.this.pre.put(aan.wfK, aan);
                                            }
                                        }
                                    }
                                    size = FacingCreateChatRoomAllInOneUI.this.prd.size();
                                    for (i = 0; i < size; i++) {
                                        aan = (aan) FacingCreateChatRoomAllInOneUI.this.prd.get(i);
                                        if (FacingCreateChatRoomAllInOneUI.this.pre.containsKey(aan.wfK)) {
                                            FacingCreateChatRoomAllInOneUI.this.pre.remove(aan.wfK);
                                        } else {
                                            ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", aan.wfK);
                                        }
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.pre != null && FacingCreateChatRoomAllInOneUI.this.pre.size() > 0) {
                                        for (Entry value : FacingCreateChatRoomAllInOneUI.this.pre.entrySet()) {
                                            FacingCreateChatRoomAllInOneUI.this.prf.add((aan) value.getValue());
                                            ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", aan.wfK);
                                        }
                                    }
                                    FacingCreateChatRoomAllInOneUI.this.prd.addAll(FacingCreateChatRoomAllInOneUI.this.prf);
                                    FacingCreateChatRoomAllInOneUI.this.mHandler.sendEmptyMessage(10001);
                                    AppMethodBeat.o(23989);
                                }
                            });
                            this.elr = aVar.cbS().wdB;
                            AppMethodBeat.o(24016);
                            return;
                        }
                    } else if (i == 0 && i2 == 0) {
                        a(a.Normal);
                        this.pru = this.pra.getHeight();
                        ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", Integer.valueOf(this.pru));
                        this.prv = AnimationUtils.loadAnimation(this, R.anim.ay);
                        this.prx = AnimationUtils.loadAnimation(this, R.anim.ar);
                        this.prw = new AnimationSet(true);
                        this.prw.addAnimation(AnimationUtils.loadAnimation(this, R.anim.cx));
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.pru));
                        translateAnimation.setDuration(300);
                        this.prw.addAnimation(translateAnimation);
                        this.prv.setDuration(200);
                        this.prw.setDuration(300);
                        this.prx.setDuration(300);
                        this.prv.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prw.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prx.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prw.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.prw.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.i(23986);
                                FacingCreateChatRoomAllInOneUI.this.prh.setVisibility(4);
                                AppMethodBeat.o(23986);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(23987);
                                FacingCreateChatRoomAllInOneUI.this.pro.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.pqV.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prj.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prk.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prh.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.pqW.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.pqZ.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.pqV.clearAnimation();
                                FacingCreateChatRoomAllInOneUI.this.prj.clearAnimation();
                                FacingCreateChatRoomAllInOneUI.this.prh.clearAnimation();
                                AppMethodBeat.o(23987);
                            }
                        });
                        this.pqV.setVisibility(4);
                        this.pqV.setAnimation(translateAnimation);
                        this.pqZ.startAnimation(this.prv);
                        this.pqW.startAnimation(this.prv);
                        this.pra.startAnimation(this.prv);
                        this.prk.startAnimation(this.prx);
                        this.prh.startAnimation(this.prw);
                        this.prk.setVisibility(4);
                        this.pqZ.setVisibility(8);
                        this.pra.setVisibility(8);
                        this.prp = true;
                        cbT();
                        AppMethodBeat.o(24016);
                        return;
                    } else if (i2 == -431) {
                        this.pqO = true;
                        a(a.ToSimple);
                        AppMethodBeat.o(24016);
                        return;
                    } else {
                        this.pqO = true;
                        a(a.Unknow);
                        AppMethodBeat.o(24016);
                        return;
                    }
                } else if (i3 == 3) {
                    if (!(i == 0 && i2 == 0)) {
                        if (i2 == -431) {
                            a(a.ToSimple);
                            this.pqO = true;
                            AppMethodBeat.o(24016);
                            return;
                        }
                        a(a.Unknow);
                        AppMethodBeat.o(24016);
                        return;
                    }
                } else if (i3 != 1) {
                    bJc();
                    AppMethodBeat.o(24016);
                    return;
                } else if (i == 0 && i2 == 0) {
                    bJc();
                    ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", String.valueOf(aVar.cbS().vEf));
                    this.prc = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    com.tencent.mm.plugin.pwdgroup.a.gkE.d(intent, (Context) this);
                    AppMethodBeat.o(24016);
                    return;
                } else if (i2 == -432 && !this.prb) {
                    this.prb = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    AppMethodBeat.o(24016);
                    return;
                } else if (i2 == -23) {
                    bJc();
                    JN(getString(R.string.bn1));
                    if (this.prr != null) {
                        this.prr.ae(3000, 3000);
                        AppMethodBeat.o(24016);
                        return;
                    }
                } else {
                    bJc();
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this.mController.ylL, null, null);
                    } else {
                        JN(getString(R.string.dh1));
                    }
                    if (this.prr != null) {
                        this.prr.ae(3000, 3000);
                    }
                    AppMethodBeat.o(24016);
                    return;
                }
                break;
            default:
                ab.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                break;
        }
        AppMethodBeat.o(24016);
    }

    public void onBackPressed() {
        AppMethodBeat.i(24017);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(24017);
    }

    private void jU(boolean z) {
        AppMethodBeat.i(24018);
        if (this.pqZ != null) {
            this.pqZ.setKeyBoardEnable(z);
        }
        AppMethodBeat.o(24018);
    }

    private void a(a aVar) {
        AppMethodBeat.i(24019);
        if (this.pqY != null) {
            switch (aVar) {
                case Normal:
                    jU(true);
                    this.pqO = false;
                    this.pqS = false;
                    this.pqX.setVisibility(8);
                    this.pqY.setVisibility(8);
                    AppMethodBeat.o(24019);
                    return;
                case Loading:
                    jU(false);
                    this.pqY.setText(R.string.dh2);
                    this.pqX.setVisibility(0);
                    this.pqY.setVisibility(8);
                    AppMethodBeat.o(24019);
                    return;
                case ToSimple:
                    jU(true);
                    this.pqX.setVisibility(8);
                    this.pqY.setVisibility(0);
                    this.pqY.setText(R.string.dgz);
                    cbV();
                    AppMethodBeat.o(24019);
                    return;
                case Unknow:
                    jU(true);
                    this.pqX.setVisibility(8);
                    this.pqY.setVisibility(0);
                    this.pqY.setText(R.string.dh1);
                    cbV();
                    AppMethodBeat.o(24019);
                    return;
                default:
                    ab.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    break;
            }
        }
        AppMethodBeat.o(24019);
    }

    private void bJc() {
        AppMethodBeat.i(24020);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(24020);
    }

    private void JN(String str) {
        AppMethodBeat.i(24021);
        h.a((Context) this, str, "", getString(R.string.s6), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(24021);
    }

    private void cbT() {
        AppMethodBeat.i(24022);
        this.jIN = false;
        if (this.prr != null) {
            this.prr.ae(0, 0);
        }
        AppMethodBeat.o(24022);
    }

    private void cbU() {
        AppMethodBeat.i(24023);
        this.jIN = true;
        if (this.prr != null) {
            this.prr.stopTimer();
        }
        aw.Rg().c(this.prs);
        AppMethodBeat.o(24023);
    }

    private void cbV() {
        AppMethodBeat.i(24024);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.o);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.n);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(23990);
                FacingCreateChatRoomAllInOneUI.this.pqV.axQ();
                FacingCreateChatRoomAllInOneUI.this.pqV.startAnimation(loadAnimation2);
                AppMethodBeat.o(23990);
            }
        });
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(23991);
                if (FacingCreateChatRoomAllInOneUI.this.pqZ != null) {
                    FacingCreateChatRoomAllInOneUI.this.pqZ.setKeyBoardEnable(true);
                }
                AppMethodBeat.o(23991);
            }
        });
        if (this.pqV != null) {
            this.pqV.startAnimation(loadAnimation);
        }
        if (this.pqZ != null) {
            this.pqZ.setKeyBoardEnable(false);
        }
        AppMethodBeat.o(24024);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24008);
        this.ylm = true;
        super.onCreate(bundle);
        if (!com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
            ab.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
            if (!b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                AppMethodBeat.o(24008);
                return;
            }
        } else if (!b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                AppMethodBeat.o(24008);
                return;
            }
            com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.g7p, new Object[]{aa.dor()}), 30764, true);
            AppMethodBeat.o(24008);
            return;
        }
        aps();
        AppMethodBeat.o(24008);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.i(24026);
        facingCreateChatRoomAllInOneUI.getString(R.string.tz);
        facingCreateChatRoomAllInOneUI.gqo = h.b((Context) facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(23988);
                FacingCreateChatRoomAllInOneUI.cbW();
                AppMethodBeat.o(23988);
            }
        });
        facingCreateChatRoomAllInOneUI.cbU();
        aw.Rg().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.pqU, facingCreateChatRoomAllInOneUI.elr, facingCreateChatRoomAllInOneUI.pqT.fBr, facingCreateChatRoomAllInOneUI.pqT.fBs, facingCreateChatRoomAllInOneUI.pqT.accuracy, facingCreateChatRoomAllInOneUI.pqT.cGo, facingCreateChatRoomAllInOneUI.pqT.mac, facingCreateChatRoomAllInOneUI.pqT.cGq), 0);
        AppMethodBeat.o(24026);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.i(24027);
        ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.prC != null) {
            facingCreateChatRoomAllInOneUI.prC.stopTimer();
        }
        if (facingCreateChatRoomAllInOneUI.pqQ) {
            if (facingCreateChatRoomAllInOneUI.pqP) {
                facingCreateChatRoomAllInOneUI.a(a.Loading);
            }
            if (facingCreateChatRoomAllInOneUI.pqQ && facingCreateChatRoomAllInOneUI.pqP && !facingCreateChatRoomAllInOneUI.pqR) {
                ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.pqR = true;
                facingCreateChatRoomAllInOneUI.pqP = false;
                facingCreateChatRoomAllInOneUI.prt = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.pqU, "", facingCreateChatRoomAllInOneUI.pqT.fBr, facingCreateChatRoomAllInOneUI.pqT.fBs, facingCreateChatRoomAllInOneUI.pqT.accuracy, facingCreateChatRoomAllInOneUI.pqT.cGo, facingCreateChatRoomAllInOneUI.pqT.mac, facingCreateChatRoomAllInOneUI.pqT.cGq);
                aw.Rg().a(facingCreateChatRoomAllInOneUI.prt, 0);
            }
            AppMethodBeat.o(24027);
            return;
        }
        ab.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.a(a.Loading);
        if (facingCreateChatRoomAllInOneUI.prC != null) {
            facingCreateChatRoomAllInOneUI.prC.ae(15000, 15000);
        }
        AppMethodBeat.o(24027);
    }

    static /* synthetic */ void cbW() {
        AppMethodBeat.i(24029);
        aw.Rg().cancel(653);
        AppMethodBeat.o(24029);
    }
}
