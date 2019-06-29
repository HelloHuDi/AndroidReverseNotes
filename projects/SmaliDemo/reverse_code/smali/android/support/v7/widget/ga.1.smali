.class Landroid/support/v7/widget/ga;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/SearchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/SearchView;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/SearchView;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/SearchView;

    .line 975
    iput-object p1, p0, Landroid/support/v7/widget/ga;->a:Landroid/support/v7/widget/SearchView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .line 978
    iget-object v0, p0, Landroid/support/v7/widget/ga;->a:Landroid/support/v7/widget/SearchView;

    iget-object v1, v0, Landroid/support/v7/widget/SearchView;->u:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_0

    .line 979
    invoke-virtual {v0}, Landroid/support/v7/widget/SearchView;->e()V

    goto :goto_0

    .line 980
    :cond_0
    iget-object v1, v0, Landroid/support/v7/widget/SearchView;->w:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_1

    .line 981
    invoke-virtual {v0}, Landroid/support/v7/widget/SearchView;->d()V

    goto :goto_0

    .line 982
    :cond_1
    iget-object v1, v0, Landroid/support/v7/widget/SearchView;->v:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_2

    .line 983
    invoke-virtual {v0}, Landroid/support/v7/widget/SearchView;->f()V

    goto :goto_0

    .line 984
    :cond_2
    iget-object v1, v0, Landroid/support/v7/widget/SearchView;->x:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_3

    .line 985
    invoke-virtual {v0}, Landroid/support/v7/widget/SearchView;->h()V

    goto :goto_0

    .line 986
    :cond_3
    iget-object v1, v0, Landroid/support/v7/widget/SearchView;->q:Landroid/support/v7/widget/SearchView$SearchAutoComplete;

    if-ne p1, v1, :cond_4

    .line 987
    invoke-virtual {v0}, Landroid/support/v7/widget/SearchView;->b()V

    .line 989
    :cond_4
    :goto_0
    return-void
.end method
