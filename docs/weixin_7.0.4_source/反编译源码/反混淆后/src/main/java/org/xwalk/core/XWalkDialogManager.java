package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;
import java.util.Iterator;

public class XWalkDialogManager {
    public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
    public static final int DIALOG_DECOMPRESSING = 11;
    public static final int DIALOG_DOWNLOADING = 12;
    public static final int DIALOG_DOWNLOAD_ERROR = 6;
    public static final int DIALOG_NEWER_VERSION = 3;
    public static final int DIALOG_NOT_FOUND = 1;
    public static final int DIALOG_OLDER_VERSION = 2;
    public static final int DIALOG_SELECT_STORE = 7;
    public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
    public static final int DIALOG_UNSUPPORTED_STORE = 8;
    private static final String TAG = "XWalkLib";
    private Dialog mActiveDialog;
    private AlertDialog mArchitectureMismatchDialog;
    private Context mContext;
    private ProgressDialog mDecompressingDialog;
    private AlertDialog mDownloadErrorDialog;
    private ProgressDialog mDownloadingDialog;
    private AlertDialog mNewerVersionDialog;
    private AlertDialog mNotFoundDialog;
    private AlertDialog mOlderVersionDialog;
    private AlertDialog mSelectStoreDialog;
    private AlertDialog mSignatureCheckErrorDialog;
    private AlertDialog mUnsupportedStoreDialog;

    static class ButtonAction {
        Runnable mClickAction;
        boolean mMandatory;
        int mWhich;

        ButtonAction(int i, Runnable runnable, boolean z) {
            this.mWhich = i;
            this.mClickAction = runnable;
            this.mMandatory = z;
        }
    }

    public XWalkDialogManager(Context context) {
        this.mContext = context;
    }

    public void setAlertDialog(int i, AlertDialog alertDialog) {
        AppMethodBeat.m2504i(85604);
        IllegalArgumentException illegalArgumentException;
        if ((alertDialog instanceof ProgressDialog) || (alertDialog instanceof DatePickerDialog) || (alertDialog instanceof TimePickerDialog)) {
            illegalArgumentException = new IllegalArgumentException("The type of dialog must be AlertDialog");
            AppMethodBeat.m2505o(85604);
            throw illegalArgumentException;
        } else if (i == 1) {
            this.mNotFoundDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 2) {
            this.mOlderVersionDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 3) {
            this.mNewerVersionDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 4) {
            this.mArchitectureMismatchDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 5) {
            this.mSignatureCheckErrorDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 6) {
            this.mDownloadErrorDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 7) {
            this.mSelectStoreDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else if (i == 8) {
            this.mUnsupportedStoreDialog = alertDialog;
            AppMethodBeat.m2505o(85604);
        } else {
            illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(85604);
            throw illegalArgumentException;
        }
    }

    public void setProgressDialog(int i, ProgressDialog progressDialog) {
        AppMethodBeat.m2504i(85605);
        if (i == 11) {
            this.mDecompressingDialog = progressDialog;
            AppMethodBeat.m2505o(85605);
        } else if (i == 12) {
            this.mDownloadingDialog = progressDialog;
            AppMethodBeat.m2505o(85605);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(85605);
            throw illegalArgumentException;
        }
    }

    public AlertDialog getAlertDialog(int i) {
        AppMethodBeat.m2504i(85606);
        AlertDialog alertDialog;
        if (i == 1) {
            if (this.mNotFoundDialog == null) {
                this.mNotFoundDialog = buildAlertDialog();
                setTitle(this.mNotFoundDialog, C25738R.string.g9m);
                setMessage(this.mNotFoundDialog, (int) C25738R.string.g9l);
                setPositiveButton(this.mNotFoundDialog, C25738R.string.gbl);
                setNegativeButton(this.mNotFoundDialog, C25738R.string.gbj);
            }
            alertDialog = this.mNotFoundDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 2) {
            if (this.mOlderVersionDialog == null) {
                this.mOlderVersionDialog = buildAlertDialog();
                setTitle(this.mOlderVersionDialog, C25738R.string.g9o);
                setMessage(this.mOlderVersionDialog, (int) C25738R.string.g9n);
                setPositiveButton(this.mOlderVersionDialog, C25738R.string.gbl);
                setNegativeButton(this.mOlderVersionDialog, C25738R.string.gbj);
            }
            alertDialog = this.mOlderVersionDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 3) {
            if (this.mNewerVersionDialog == null) {
                this.mNewerVersionDialog = buildAlertDialog();
                setTitle(this.mNewerVersionDialog, C25738R.string.g9k);
                setMessage(this.mNewerVersionDialog, (int) C25738R.string.g9j);
                setNegativeButton(this.mNewerVersionDialog, C25738R.string.gbj);
            }
            alertDialog = this.mNewerVersionDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 4) {
            if (this.mArchitectureMismatchDialog == null) {
                this.mArchitectureMismatchDialog = buildAlertDialog();
                setTitle(this.mArchitectureMismatchDialog, C25738R.string.g9i);
                setMessage(this.mArchitectureMismatchDialog, (int) C25738R.string.g9h);
                setPositiveButton(this.mArchitectureMismatchDialog, C25738R.string.gbl);
                setNegativeButton(this.mArchitectureMismatchDialog, C25738R.string.gbj);
            }
            alertDialog = this.mArchitectureMismatchDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 5) {
            if (this.mSignatureCheckErrorDialog == null) {
                this.mSignatureCheckErrorDialog = buildAlertDialog();
                setTitle(this.mSignatureCheckErrorDialog, C25738R.string.g9q);
                setMessage(this.mSignatureCheckErrorDialog, (int) C25738R.string.g9p);
                setNegativeButton(this.mSignatureCheckErrorDialog, C25738R.string.gbj);
            }
            alertDialog = this.mSignatureCheckErrorDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 6) {
            if (this.mDownloadErrorDialog == null) {
                this.mDownloadErrorDialog = buildAlertDialog();
                setTitle(this.mDownloadErrorDialog, C25738R.string.g6q);
                setMessage(this.mDownloadErrorDialog, (int) C25738R.string.g70);
                setPositiveButton(this.mDownloadErrorDialog, C25738R.string.gbm);
                setNegativeButton(this.mDownloadErrorDialog, C25738R.string.gbi);
            }
            alertDialog = this.mDownloadErrorDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 7) {
            if (this.mSelectStoreDialog == null) {
                this.mSelectStoreDialog = buildAlertDialog();
                setTitle(this.mSelectStoreDialog, C25738R.string.g6q);
                setPositiveButton(this.mSelectStoreDialog, C25738R.string.gbk);
            }
            alertDialog = this.mSelectStoreDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else if (i == 8) {
            if (this.mUnsupportedStoreDialog == null) {
                this.mUnsupportedStoreDialog = buildAlertDialog();
                setTitle(this.mUnsupportedStoreDialog, C25738R.string.g6q);
                setMessage(this.mUnsupportedStoreDialog, (int) C25738R.string.gal);
                setNegativeButton(this.mUnsupportedStoreDialog, C25738R.string.gbj);
            }
            alertDialog = this.mUnsupportedStoreDialog;
            AppMethodBeat.m2505o(85606);
            return alertDialog;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(85606);
            throw illegalArgumentException;
        }
    }

    public ProgressDialog getProgressDialog(int i) {
        AppMethodBeat.m2504i(85607);
        ProgressDialog progressDialog;
        if (i == 11) {
            if (this.mDecompressingDialog == null) {
                this.mDecompressingDialog = buildProgressDialog();
                setTitle(this.mDecompressingDialog, C25738R.string.g6q);
                setMessage(this.mDecompressingDialog, (int) C25738R.string.g6r);
                setNegativeButton(this.mDecompressingDialog, C25738R.string.gbi);
                this.mDecompressingDialog.setProgressStyle(0);
            }
            progressDialog = this.mDecompressingDialog;
            AppMethodBeat.m2505o(85607);
            return progressDialog;
        } else if (i == 12) {
            if (this.mDownloadingDialog == null) {
                this.mDownloadingDialog = buildProgressDialog();
                setTitle(this.mDownloadingDialog, C25738R.string.g6q);
                setMessage(this.mDownloadingDialog, (int) C25738R.string.g72);
                setNegativeButton(this.mDownloadingDialog, C25738R.string.gbi);
                this.mDownloadingDialog.setProgressStyle(1);
            }
            progressDialog = this.mDownloadingDialog;
            AppMethodBeat.m2505o(85607);
            return progressDialog;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(85607);
            throw illegalArgumentException;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void showInitializationError(int i, Runnable runnable, Runnable runnable2) {
        AlertDialog alertDialog;
        AppMethodBeat.m2504i(85608);
        ArrayList arrayList = new ArrayList();
        if (i == 2) {
            alertDialog = getAlertDialog(1);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 3) {
            alertDialog = getAlertDialog(2);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 4) {
            alertDialog = getAlertDialog(3);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else if (i == 6) {
            alertDialog = getAlertDialog(4);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 7) {
            alertDialog = getAlertDialog(5);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid status ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(85608);
            throw illegalArgumentException;
        }
        showDialog(alertDialog, arrayList);
        AppMethodBeat.m2505o(85608);
    }

    /* Access modifiers changed, original: 0000 */
    public void showDownloadError(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.m2504i(85609);
        AlertDialog alertDialog = getAlertDialog(6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-1, runnable2, true));
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.m2505o(85609);
    }

    /* Access modifiers changed, original: 0000 */
    public void showSelectStore(Runnable runnable, String str) {
        AppMethodBeat.m2504i(85610);
        AlertDialog alertDialog = getAlertDialog(7);
        setMessage(alertDialog, this.mContext.getString(C25738R.string.g8x).replace("STORE_NAME", str));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-1, runnable, true));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.m2505o(85610);
    }

    /* Access modifiers changed, original: 0000 */
    public void showUnsupportedStore(Runnable runnable) {
        AppMethodBeat.m2504i(85611);
        AlertDialog alertDialog = getAlertDialog(8);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, true));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.m2505o(85611);
    }

    /* Access modifiers changed, original: 0000 */
    public void showDecompressProgress(Runnable runnable) {
        AppMethodBeat.m2504i(85612);
        ProgressDialog progressDialog = getProgressDialog(11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
        AppMethodBeat.m2505o(85612);
    }

    /* Access modifiers changed, original: 0000 */
    public void showDownloadProgress(Runnable runnable) {
        AppMethodBeat.m2504i(85613);
        ProgressDialog progressDialog = getProgressDialog(12);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
        AppMethodBeat.m2505o(85613);
    }

    /* Access modifiers changed, original: 0000 */
    public void dismissDialog() {
        AppMethodBeat.m2504i(85614);
        this.mActiveDialog.dismiss();
        this.mActiveDialog = null;
        AppMethodBeat.m2505o(85614);
    }

    /* Access modifiers changed, original: 0000 */
    public void setProgress(int i, int i2) {
        AppMethodBeat.m2504i(85615);
        ProgressDialog progressDialog = (ProgressDialog) this.mActiveDialog;
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(i2);
        progressDialog.setProgress(i);
        AppMethodBeat.m2505o(85615);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isShowingDialog() {
        AppMethodBeat.m2504i(85616);
        if (this.mActiveDialog == null || !this.mActiveDialog.isShowing()) {
            AppMethodBeat.m2505o(85616);
            return false;
        }
        AppMethodBeat.m2505o(85616);
        return true;
    }

    private AlertDialog buildAlertDialog() {
        AppMethodBeat.m2504i(85617);
        AlertDialog create = new Builder(this.mContext).create();
        create.setIcon(17301543);
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(85617);
        return create;
    }

    private ProgressDialog buildProgressDialog() {
        AppMethodBeat.m2504i(85618);
        ProgressDialog progressDialog = new ProgressDialog(this.mContext);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(85618);
        return progressDialog;
    }

    private void setTitle(AlertDialog alertDialog, int i) {
        AppMethodBeat.m2504i(85619);
        alertDialog.setTitle(this.mContext.getString(i));
        AppMethodBeat.m2505o(85619);
    }

    private void setMessage(AlertDialog alertDialog, int i) {
        AppMethodBeat.m2504i(85620);
        setMessage(alertDialog, this.mContext.getString(i));
        AppMethodBeat.m2505o(85620);
    }

    private void setMessage(AlertDialog alertDialog, String str) {
        AppMethodBeat.m2504i(85621);
        CharSequence replaceAll = str.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
        if (replaceAll.startsWith("this")) {
            replaceAll = replaceAll.replaceFirst("this", "This");
        }
        alertDialog.setMessage(replaceAll);
        AppMethodBeat.m2505o(85621);
    }

    private void setPositiveButton(AlertDialog alertDialog, int i) {
        AppMethodBeat.m2504i(85622);
        alertDialog.setButton(-1, this.mContext.getString(i), null);
        AppMethodBeat.m2505o(85622);
    }

    private void setNegativeButton(AlertDialog alertDialog, int i) {
        AppMethodBeat.m2504i(85623);
        alertDialog.setButton(-2, this.mContext.getString(i), null);
        AppMethodBeat.m2505o(85623);
    }

    private void showDialog(final AlertDialog alertDialog, final ArrayList<ButtonAction> arrayList) {
        AppMethodBeat.m2504i(85624);
        alertDialog.setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(85603);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ButtonAction buttonAction = (ButtonAction) it.next();
                    Button button = alertDialog.getButton(buttonAction.mWhich);
                    if (button == null) {
                        if (buttonAction.mMandatory) {
                            RuntimeException runtimeException = new RuntimeException("Button " + buttonAction.mWhich + " is mandatory");
                            AppMethodBeat.m2505o(85603);
                            throw runtimeException;
                        }
                    } else if (buttonAction.mClickAction != null) {
                        final Runnable runnable = buttonAction.mClickAction;
                        button.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                AppMethodBeat.m2504i(85602);
                                XWalkDialogManager.this.dismissDialog();
                                runnable.run();
                                AppMethodBeat.m2505o(85602);
                            }
                        });
                    }
                }
                AppMethodBeat.m2505o(85603);
            }
        });
        this.mActiveDialog = alertDialog;
        this.mActiveDialog.show();
        AppMethodBeat.m2505o(85624);
    }
}
