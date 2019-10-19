# jmx-monitor

### 简介
通过`JMX`监控线程池，并提供`HTTP`连接，可在页面查看监控指标

### 线程池监控指标
| 监控指标 | 含义 |
| :------: | :------: |
| ActiveCount | 线程池中正在执行任务的线程数量 |
| CompletedTaskCount | 线程池已完成的任务数量 |
| CorePoolSize | 线程池的核心线程数量 |
| LargestPoolSize | 线程池曾经创建过的最大线程数量 |
| MaximumPoolSize | 线程池的最大线程数量 |
| PoolSize | 线程池当前的线程数量 |
| TaskCount | 线程池需要执行的任务数量 |
| MaxCostTime | 线程最大耗时 |
| MinCostTime | 线程最小耗时 |
| 线程平均耗时 | AverageCostTime |

### 项目运行Demo
`Demo`位于`test`包下，启动程序以后打开`http://localhost:8082/`页面即可查看监控指标参数


