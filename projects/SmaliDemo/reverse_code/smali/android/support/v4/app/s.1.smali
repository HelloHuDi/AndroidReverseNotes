.class Landroid/support/v4/app/s;
.super Landroid/animation/AnimatorListenerAdapter;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;Landroid/support/v4/app/v$c;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/ViewGroup;

.field final synthetic b:Landroid/view/View;

.field final synthetic c:Landroid/support/v4/app/i;

.field final synthetic d:Landroid/support/v4/app/v;


# direct methods
.method constructor <init>(Landroid/support/v4/app/v;Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/v4/app/i;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/v;

    .line 1664
    iput-object p1, p0, Landroid/support/v4/app/s;->d:Landroid/support/v4/app/v;

    iput-object p2, p0, Landroid/support/v4/app/s;->a:Landroid/view/ViewGroup;

    iput-object p3, p0, Landroid/support/v4/app/s;->b:Landroid/view/View;

    iput-object p4, p0, Landroid/support/v4/app/s;->c:Landroid/support/v4/app/i;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 8
    .param p1, "anim"    # Landroid/animation/Animator;

    .line 1667
    iget-object v0, p0, Landroid/support/v4/app/s;->a:Landroid/view/ViewGroup;

    iget-object v1, p0, Landroid/support/v4/app/s;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->endViewTransition(Landroid/view/View;)V

    .line 1670
    iget-object v0, p0, Landroid/support/v4/app/s;->c:Landroid/support/v4/app/i;

    invoke-virtual {v0}, Landroid/support/v4/app/i;->h()Landroid/animation/Animator;

    move-result-object v0

    .line 1671
    .local v0, "animator":Landroid/animation/Animator;
    iget-object v1, p0, Landroid/support/v4/app/s;->c:Landroid/support/v4/app/i;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/support/v4/app/i;->a(Landroid/animation/Animator;)V

    .line 1672
    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v4/app/s;->a:Landroid/view/ViewGroup;

    iget-object v2, p0, Landroid/support/v4/app/s;->b:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v1

    if-gez v1, :cond_0

    .line 1673
    iget-object v2, p0, Landroid/support/v4/app/s;->d:Landroid/support/v4/app/v;

    iget-object v3, p0, Landroid/support/v4/app/s;->c:Landroid/support/v4/app/i;

    invoke-virtual {v3}, Landroid/support/v4/app/i;->x()I

    move-result v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;IIIZ)V

    .line 1675
    :cond_0
    return-void
.end method
