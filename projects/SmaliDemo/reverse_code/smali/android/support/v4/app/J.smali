.class Landroid/support/v4/app/J;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/transition/Transition$TransitionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/L;->a(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Object;

.field final synthetic b:Ljava/util/ArrayList;

.field final synthetic c:Ljava/lang/Object;

.field final synthetic d:Ljava/util/ArrayList;

.field final synthetic e:Ljava/lang/Object;

.field final synthetic f:Ljava/util/ArrayList;

.field final synthetic g:Landroid/support/v4/app/L;


# direct methods
.method constructor <init>(Landroid/support/v4/app/L;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/L;

    .line 215
    iput-object p1, p0, Landroid/support/v4/app/J;->g:Landroid/support/v4/app/L;

    iput-object p2, p0, Landroid/support/v4/app/J;->a:Ljava/lang/Object;

    iput-object p3, p0, Landroid/support/v4/app/J;->b:Ljava/util/ArrayList;

    iput-object p4, p0, Landroid/support/v4/app/J;->c:Ljava/lang/Object;

    iput-object p5, p0, Landroid/support/v4/app/J;->d:Ljava/util/ArrayList;

    iput-object p6, p0, Landroid/support/v4/app/J;->e:Ljava/lang/Object;

    iput-object p7, p0, Landroid/support/v4/app/J;->f:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTransitionCancel(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 235
    return-void
.end method

.method public onTransitionEnd(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 231
    return-void
.end method

.method public onTransitionPause(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 239
    return-void
.end method

.method public onTransitionResume(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 243
    return-void
.end method

.method public onTransitionStart(Landroid/transition/Transition;)V
    .locals 4
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 218
    iget-object v0, p0, Landroid/support/v4/app/J;->a:Ljava/lang/Object;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 219
    iget-object v2, p0, Landroid/support/v4/app/J;->g:Landroid/support/v4/app/L;

    iget-object v3, p0, Landroid/support/v4/app/J;->b:Ljava/util/ArrayList;

    invoke-virtual {v2, v0, v3, v1}, Landroid/support/v4/app/L;->a(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 221
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/J;->c:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 222
    iget-object v2, p0, Landroid/support/v4/app/J;->g:Landroid/support/v4/app/L;

    iget-object v3, p0, Landroid/support/v4/app/J;->d:Ljava/util/ArrayList;

    invoke-virtual {v2, v0, v3, v1}, Landroid/support/v4/app/L;->a(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 224
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/J;->e:Ljava/lang/Object;

    if-eqz v0, :cond_2

    .line 225
    iget-object v2, p0, Landroid/support/v4/app/J;->g:Landroid/support/v4/app/L;

    iget-object v3, p0, Landroid/support/v4/app/J;->f:Ljava/util/ArrayList;

    invoke-virtual {v2, v0, v3, v1}, Landroid/support/v4/app/L;->a(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 227
    :cond_2
    return-void
.end method
