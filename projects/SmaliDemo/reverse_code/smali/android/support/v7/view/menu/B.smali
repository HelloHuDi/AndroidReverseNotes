.class Landroid/support/v7/view/menu/B;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnAttachStateChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/C;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/view/menu/C;


# direct methods
.method constructor <init>(Landroid/support/v7/view/menu/C;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/C;

    .line 80
    iput-object p1, p0, Landroid/support/v7/view/menu/B;->a:Landroid/support/v7/view/menu/C;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onViewAttachedToWindow(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .line 83
    return-void
.end method

.method public onViewDetachedFromWindow(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .line 87
    iget-object v0, p0, Landroid/support/v7/view/menu/B;->a:Landroid/support/v7/view/menu/C;

    iget-object v0, v0, Landroid/support/v7/view/menu/C;->q:Landroid/view/ViewTreeObserver;

    if-eqz v0, :cond_1

    .line 88
    invoke-virtual {v0}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/view/menu/B;->a:Landroid/support/v7/view/menu/C;

    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    iput-object v1, v0, Landroid/support/v7/view/menu/C;->q:Landroid/view/ViewTreeObserver;

    .line 89
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/B;->a:Landroid/support/v7/view/menu/C;

    iget-object v1, v0, Landroid/support/v7/view/menu/C;->q:Landroid/view/ViewTreeObserver;

    iget-object v0, v0, Landroid/support/v7/view/menu/C;->k:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v1, v0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 91
    :cond_1
    invoke-virtual {p1, p0}, Landroid/view/View;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    .line 92
    return-void
.end method
