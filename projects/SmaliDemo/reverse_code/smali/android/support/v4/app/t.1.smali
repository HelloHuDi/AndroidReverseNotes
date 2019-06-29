.class Landroid/support/v4/app/t;
.super Landroid/animation/AnimatorListenerAdapter;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/v;->b(Landroid/support/v4/app/i;)V
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

    .line 1728
    iput-object p1, p0, Landroid/support/v4/app/t;->d:Landroid/support/v4/app/v;

    iput-object p2, p0, Landroid/support/v4/app/t;->a:Landroid/view/ViewGroup;

    iput-object p3, p0, Landroid/support/v4/app/t;->b:Landroid/view/View;

    iput-object p4, p0, Landroid/support/v4/app/t;->c:Landroid/support/v4/app/i;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 1731
    iget-object v0, p0, Landroid/support/v4/app/t;->a:Landroid/view/ViewGroup;

    iget-object v1, p0, Landroid/support/v4/app/t;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->endViewTransition(Landroid/view/View;)V

    .line 1732
    invoke-virtual {p1, p0}, Landroid/animation/Animator;->removeListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 1733
    iget-object v0, p0, Landroid/support/v4/app/t;->c:Landroid/support/v4/app/i;

    iget-object v0, v0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1734
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1736
    :cond_0
    return-void
.end method
