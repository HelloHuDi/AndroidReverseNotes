package com.tencent.p177mm.p612ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.MMWizardActivity */
public abstract class MMWizardActivity extends MMActivity {
    protected static final Map<String, Intent> ynD = new HashMap();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.MMWizardActivity", "onCreate()");
        Assert.assertFalse("MMWizardActivity Should Start By startWizardActivity or startWizardNextStep", C5046bo.isNullOrNil(getIntent().getExtras().getString("WizardRootClass")));
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            super.finish();
            C4990ab.m7416i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
            exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
        }
    }

    /* renamed from: J */
    public static void m23791J(Context context, Intent intent) {
        String stringExtra;
        String str;
        C4990ab.m7416i("MicroMsg.MMWizardActivity", "startWizardActivity()");
        Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + context.toString(), context instanceof Activity);
        Intent intent2 = ((Activity) context).getIntent();
        if (intent2 != null) {
            String stringExtra2 = intent2.getStringExtra("WizardRootClass");
            stringExtra = intent2.getStringExtra("WizardTransactionId");
            str = stringExtra2;
        } else {
            stringExtra = null;
            str = null;
        }
        if (C5046bo.isNullOrNil(str)) {
            try {
                str = intent.getComponent().getClassName();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMWizardActivity", e, "", new Object[0]);
            }
        }
        Assert.assertFalse("startWizardActivity: ERROR in Get Root Class :[" + intent + "][ " + intent.getComponent() + " ]", C5046bo.isNullOrNil(str));
        intent.putExtra("WizardRootClass", str);
        if (stringExtra != null) {
            intent.putExtra("WizardTransactionId", stringExtra);
        }
        context.startActivity(intent);
    }

    /* renamed from: b */
    public static void m23792b(Context context, Intent intent, Intent intent2) {
        try {
            String str = "trans." + C5046bo.m7588yz() + "." + intent2.hashCode();
            ynD.put(str, intent2);
            intent.putExtra("WizardTransactionId", str);
            Intent intent3 = ((Activity) context).getIntent();
            if (intent3 != null) {
                intent3.putExtra("WizardTransactionId", str);
            }
            MMWizardActivity.m23791J(context, intent);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMWizardActivity", "%s", C5046bo.m7574l(e));
        }
    }

    public final void exit(int i) {
        C4990ab.m7416i("MicroMsg.MMWizardActivity", "exit()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = (Intent) ynD.get(stringExtra);
        ynD.remove(stringExtra);
        if (intent != null) {
            C4990ab.m7410d("MicroMsg.MMWizardActivity", "doing post exit for transaction=" + stringExtra + ", intent=" + intent);
            intent.putExtra("wizard_activity_result_code", i);
            startActivity(intent);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cancel() {
        C4990ab.m7416i("MicroMsg.MMWizardActivity", "cancel()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = (Intent) ynD.get(stringExtra);
        ynD.remove(stringExtra);
        if (intent != null) {
            C4990ab.m7410d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + stringExtra + ", intent=" + intent);
        }
    }

    /* renamed from: Ni */
    public final void mo27541Ni(int i) {
        C4990ab.m7416i("MicroMsg.MMWizardActivity", "finishWizard()");
        String string = getIntent().getExtras().getString("WizardRootClass");
        Assert.assertFalse("finishWizard: ERROR in Get Root Class :[" + string + "]", C5046bo.isNullOrNil(string));
        Intent className = new Intent().setClassName(this, string);
        className.putExtra("WizardRootClass", getIntent().getStringExtra("WizardRootClass"));
        className.putExtra("WizardTransactionId", getIntent().getStringExtra("WizardTransactionId"));
        className.putExtra("WizardRootKillSelf", true);
        className.putExtra("wizard_activity_result_code", i);
        className.addFlags(67108864);
        startActivity(className);
    }

    public void finish() {
        C4990ab.m7416i("MicroMsg.MMWizardActivity", "finish()");
        if (getComponentName().getClassName().equals(getIntent().getStringExtra("WizardRootClass"))) {
            C4990ab.m7410d("MicroMsg.MMWizardActivity", "root wizard activity");
            exit(-1);
        }
        super.finish();
    }
}
