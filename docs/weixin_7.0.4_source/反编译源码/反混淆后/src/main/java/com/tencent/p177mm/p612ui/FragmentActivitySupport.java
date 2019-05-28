package com.tencent.p177mm.p612ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.FragmentActivitySupport */
public abstract class FragmentActivitySupport extends Fragment {
    public boolean hasDestory;
    public boolean isCurrentActivity;
    private FragmentActivity mActivity;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = getActivity();
    }

    public void onDestroy() {
        super.onDestroy();
        this.hasDestory = true;
    }

    public FragmentActivitySupport(boolean z) {
        this.hasDestory = false;
        this.isCurrentActivity = z;
    }

    public FragmentActivitySupport() {
        this.hasDestory = false;
        this.isCurrentActivity = false;
    }

    public void startActivity(Intent intent) {
        FragmentActivity thisActivity = thisActivity();
        if (thisActivity == null) {
            C4996ah.getContext().startActivity(intent);
        } else {
            thisActivity.startActivityFromFragment(this, intent, -1);
        }
    }

    public void finish() {
        if (this.isCurrentActivity) {
            if (thisActivity() != null) {
                thisActivity().finish();
            }
        } else if (thisActivity() != null) {
            thisActivity().getSupportFragmentManager().popBackStack();
        }
    }

    public int getIntExtra(String str, int i) {
        if (this.isCurrentActivity && getArguments() == null && thisActivity() != null) {
            return thisActivity().getIntent().getIntExtra(str, i);
        }
        if (getArguments() != null) {
            return getArguments().getInt(str, i);
        }
        return i;
    }

    public String getStringExtra(String str) {
        String str2 = null;
        if (this.isCurrentActivity && thisActivity() != null) {
            str2 = thisActivity().getIntent().getStringExtra(str);
        }
        if (str2 != null || getArguments() == null) {
            return str2;
        }
        return super.getArguments().getString(str);
    }

    public <T extends Parcelable> T getParcelableExtra(String str) {
        T t = null;
        if (this.isCurrentActivity && thisActivity() != null) {
            t = thisActivity().getIntent().getParcelableExtra(str);
        }
        if (t != null || getArguments() == null) {
            return t;
        }
        return super.getArguments().getParcelable(str);
    }

    public String getPackageName() {
        return thisActivity().getPackageName();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return thisActivity().getSharedPreferences(str, i);
    }

    public LayoutInflater getActivityLayoutInflater() {
        return thisActivity().getLayoutInflater();
    }

    public FragmentActivity thisActivity() {
        if (this.mActivity == null) {
            this.mActivity = getActivity();
        }
        return this.mActivity;
    }

    public View findViewById(int i) {
        View view = getView();
        View view2 = null;
        if (view != null) {
            view2 = view.findViewById(i);
        }
        return view2 != null ? view2 : thisActivity().findViewById(i);
    }

    public void sendBroadcast(Intent intent) {
        thisActivity().sendBroadcast(intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        } else if (i == 82 && keyEvent.getAction() == 1) {
            return onKeyUp(i, keyEvent);
        } else {
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean isFinishing() {
        if (thisActivity() == null) {
            return true;
        }
        return thisActivity().isFinishing();
    }

    public void setRequestedOrientation(int i) {
        if (thisActivity() != null) {
            thisActivity().setRequestedOrientation(i);
        }
    }

    public WindowManager getWindowManager() {
        if (thisActivity() != null) {
            return thisActivity().getWindowManager();
        }
        return null;
    }

    public Window getWindow() {
        if (thisActivity() != null) {
            return thisActivity().getWindow();
        }
        return null;
    }

    public void openContextMenu(View view) {
        if (thisActivity() != null) {
            thisActivity().openContextMenu(view);
        }
    }

    public ContentResolver getContentResolver() {
        if (thisActivity() != null) {
            return thisActivity().getContentResolver();
        }
        return null;
    }

    public Boolean getBooleanExtra(String str, boolean z) {
        if (this.isCurrentActivity && getArguments() == null) {
            return Boolean.valueOf(thisActivity().getIntent().getBooleanExtra(str, z));
        }
        return Boolean.valueOf(getArguments().getBoolean(str, z));
    }

    public ArrayList<String> getStringArrayList(String str) {
        if (this.isCurrentActivity && getArguments() == null) {
            return thisActivity().getIntent().getStringArrayListExtra(str);
        }
        return getArguments().getStringArrayList(str);
    }

    public long getLongExtra(String str, long j) {
        if (this.isCurrentActivity && getArguments() == null) {
            return thisActivity().getIntent().getLongExtra(str, j);
        }
        if (getArguments() != null) {
            return getArguments().getLong(str, j);
        }
        return j;
    }

    public void setResult(int i) {
        if (this.isCurrentActivity) {
            thisActivity().setResult(i);
        }
    }

    public void setResult(int i, Intent intent) {
        if (this.isCurrentActivity) {
            thisActivity().setResult(i);
        } else {
            thisActivity().setResult(i, intent);
        }
    }

    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (thisActivity() != null) {
            return thisActivity().managedQuery(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public void overridePendingTransition(int i, int i2) {
        if (thisActivity() != null) {
            thisActivity().overridePendingTransition(i, i2);
        }
    }

    public void startFragment(Class<?> cls, Intent intent) {
        if (this.isCurrentActivity) {
            startActivity(intent);
        }
    }

    public boolean isShowing() {
        return !this.hasDestory;
    }
}
