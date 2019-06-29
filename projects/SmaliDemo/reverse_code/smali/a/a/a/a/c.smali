.class public La/a/a/a/c;
.super La/a/a/a/e;
.source ""


# static fields
.field private static volatile a:La/a/a/a/c;

.field private static final b:Ljava/util/concurrent/Executor;

.field private static final c:Ljava/util/concurrent/Executor;


# instance fields
.field private d:La/a/a/a/e;

.field private e:La/a/a/a/e;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 42
    new-instance v0, La/a/a/a/a;

    invoke-direct {v0}, La/a/a/a/a;-><init>()V

    sput-object v0, La/a/a/a/c;->b:Ljava/util/concurrent/Executor;

    .line 50
    new-instance v0, La/a/a/a/b;

    invoke-direct {v0}, La/a/a/a/b;-><init>()V

    sput-object v0, La/a/a/a/c;->c:Ljava/util/concurrent/Executor;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 57
    invoke-direct {p0}, La/a/a/a/e;-><init>()V

    .line 58
    new-instance v0, La/a/a/a/d;

    invoke-direct {v0}, La/a/a/a/d;-><init>()V

    iput-object v0, p0, La/a/a/a/c;->e:La/a/a/a/e;

    .line 59
    iget-object v0, p0, La/a/a/a/c;->e:La/a/a/a/e;

    iput-object v0, p0, La/a/a/a/c;->d:La/a/a/a/e;

    .line 60
    return-void
.end method

.method public static b()La/a/a/a/c;
    .locals 2

    .line 69
    sget-object v0, La/a/a/a/c;->a:La/a/a/a/c;

    if-eqz v0, :cond_0

    .line 70
    sget-object v0, La/a/a/a/c;->a:La/a/a/a/c;

    return-object v0

    .line 72
    :cond_0
    const-class v0, La/a/a/a/c;

    monitor-enter v0

    .line 73
    :try_start_0
    sget-object v1, La/a/a/a/c;->a:La/a/a/a/c;

    if-nez v1, :cond_1

    .line 74
    new-instance v1, La/a/a/a/c;

    invoke-direct {v1}, La/a/a/a/c;-><init>()V

    sput-object v1, La/a/a/a/c;->a:La/a/a/a/c;

    .line 76
    :cond_1
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    sget-object v0, La/a/a/a/c;->a:La/a/a/a/c;

    return-object v0

    .line 76
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method


# virtual methods
.method public a(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .line 96
    iget-object v0, p0, La/a/a/a/c;->d:La/a/a/a/e;

    invoke-virtual {v0, p1}, La/a/a/a/e;->a(Ljava/lang/Runnable;)V

    .line 97
    return-void
.end method

.method public a()Z
    .locals 1

    .line 116
    iget-object v0, p0, La/a/a/a/c;->d:La/a/a/a/e;

    invoke-virtual {v0}, La/a/a/a/e;->a()Z

    move-result v0

    return v0
.end method

.method public b(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .line 101
    iget-object v0, p0, La/a/a/a/c;->d:La/a/a/a/e;

    invoke-virtual {v0, p1}, La/a/a/a/e;->b(Ljava/lang/Runnable;)V

    .line 102
    return-void
.end method
