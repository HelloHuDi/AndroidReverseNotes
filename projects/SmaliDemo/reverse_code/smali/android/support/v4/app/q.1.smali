.class Landroid/support/v4/app/q;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/r;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v4/app/r;


# direct methods
.method constructor <init>(Landroid/support/v4/app/r;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v4/app/r;

    .line 1647
    iput-object p1, p0, Landroid/support/v4/app/q;->a:Landroid/support/v4/app/r;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .line 1650
    iget-object v0, p0, Landroid/support/v4/app/q;->a:Landroid/support/v4/app/r;

    iget-object v0, v0, Landroid/support/v4/app/r;->c:Landroid/support/v4/app/i;

    invoke-virtual {v0}, Landroid/support/v4/app/i;->g()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1651
    iget-object v0, p0, Landroid/support/v4/app/q;->a:Landroid/support/v4/app/r;

    iget-object v0, v0, Landroid/support/v4/app/r;->c:Landroid/support/v4/app/i;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/i;->a(Landroid/view/View;)V

    .line 1652
    iget-object v0, p0, Landroid/support/v4/app/q;->a:Landroid/support/v4/app/r;

    iget-object v1, v0, Landroid/support/v4/app/r;->d:Landroid/support/v4/app/v;

    iget-object v2, v0, Landroid/support/v4/app/r;->c:Landroid/support/v4/app/i;

    invoke-virtual {v2}, Landroid/support/v4/app/i;->x()I

    move-result v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;IIIZ)V

    .line 1655
    :cond_0
    return-void
.end method
