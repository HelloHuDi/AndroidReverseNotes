.class Landroid/support/v7/app/G;
.super La/b/c/g/C;
.source ""


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

    .line 152
    iput-object p1, p0, Landroid/support/v7/app/G;->a:Landroid/support/v7/app/I;

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    return-void
.end method


# virtual methods
.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 155
    iget-object v0, p0, Landroid/support/v7/app/G;->a:Landroid/support/v7/app/I;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    .line 156
    iget-object v0, v0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->requestLayout()V

    .line 157
    return-void
.end method
