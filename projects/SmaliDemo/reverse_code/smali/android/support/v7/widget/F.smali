.class Landroid/support/v7/widget/F;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/widget/PopupWindow$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/C$b;->c()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

.field final synthetic b:Landroid/support/v7/widget/C$b;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/C$b;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/widget/C$b;

    .line 833
    iput-object p1, p0, Landroid/support/v7/widget/F;->b:Landroid/support/v7/widget/C$b;

    iput-object p2, p0, Landroid/support/v7/widget/F;->a:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss()V
    .locals 2

    .line 836
    iget-object v0, p0, Landroid/support/v7/widget/F;->b:Landroid/support/v7/widget/C$b;

    iget-object v0, v0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 837
    .local v0, "vto":Landroid/view/ViewTreeObserver;
    if-eqz v0, :cond_0

    .line 838
    iget-object v1, p0, Landroid/support/v7/widget/F;->a:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 840
    :cond_0
    return-void
.end method
