package android.support.p057v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.ab */
public final class C0322ab {

    /* renamed from: android.support.v4.app.ab$a */
    public static class C0321a {
        /* renamed from: FZ */
        public ArrayList<String> f276FZ;
        /* renamed from: Ga */
        public ArrayList<String> f277Ga;
        /* renamed from: Gb */
        public ArrayList<String> f278Gb;
        /* renamed from: Gc */
        public ArrayList<Uri> f279Gc;
        private Activity mActivity;
        public Intent mIntent = new Intent().setAction("android.intent.action.SEND");

        public C0321a(Activity activity) {
            this.mActivity = activity;
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", activity.getComponentName());
            this.mIntent.addFlags(SQLiteGlobal.journalSizeLimit);
        }

        /* renamed from: a */
        public final void mo516a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, strArr);
        }
    }
}
