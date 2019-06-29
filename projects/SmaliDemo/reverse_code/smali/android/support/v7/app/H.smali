.class Landroid/support/v7/app/H;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/g/D;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/I;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/I;


# direct methods
.method constructor <init>(Landroid/support/v7/app/I;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/I;

    .line 161
    iput-object p1, p0, Landroid/support/v7/app/H;->a:Landroid/support/v7/app/I;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 164
    iget-object v0, p0, Landroid/support/v7/app/H;->a:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 165
    .local v0, "parent":Landroid/view/ViewParent;
    move-object v1, v0

    check-cast v1, Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->invalidate()V

    .line 166
    return-void
.end method
