.class Landroid/support/v7/app/w;
.super La/b/c/g/C;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/app/x;->b(La/b/d/d/b$a;)La/b/d/d/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/x;

    .line 1045
    iput-object p1, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    return-void
.end method


# virtual methods
.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 1058
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 1059
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    .line 1060
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iput-object v1, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 1061
    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 1048
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    .line 1049
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->sendAccessibilityEvent(I)V

    .line 1051
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1052
    iget-object v0, p0, Landroid/support/v7/app/w;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-static {v0}, La/b/c/g/u;->m(Landroid/view/View;)V

    .line 1054
    :cond_0
    return-void
.end method
