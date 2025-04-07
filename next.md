# 用户管理系统前后端对接计划

## 当前项目进度

当前已完成：
- Spring Boot后端基础架构
- 用户实体与数据库设计
- 基本API实现（注册、登录、查询）
- 数据库连接配置
- 接口测试通过

已实现的API接口：
- `POST /api/user/register` - 用户注册
- `POST /api/user/login` - 用户登录
- `GET /api/user/{id}` - 获取指定用户
- `GET /api/user/` - 获取所有用户

## 前后端对接实现计划

### 1. 创建Vue前端项目
```bash
npm install -g @vue/cli
vue create user-management-frontend
cd user-management-frontend
npm install axios vue-router vuex element-ui
```

### 2. 配置后端CORS支持
在Spring Boot项目中添加`WebConfig.java`：
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:8081")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
```

### 3. 前端项目结构
```
user-management-frontend/
├── public/
├── src/
│   ├── assets/
│   ├── components/
│   ├── router/        - 路由配置
│   ├── services/      - API服务
│   ├── store/         - Vuex状态管理
│   ├── views/         - 页面组件
│   ├── App.vue        - 主应用组件
│   └── main.js        - 入口文件
└── package.json
```

### 4. 主要实现文件

**API服务(src/services/api.js)**:
```javascript
import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

const apiClient = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

// 用户API服务
export const userService = {
  register(userData) { /*...*/ },
  login(credentials) { /*...*/ },
  getUserById(id) { /*...*/ },
  getAllUsers() { /*...*/ }
};
```

**Vuex状态管理(src/store/index.js)**:
```javascript
import Vue from 'vue';
import Vuex from 'vuex';
import { userService } from '../services/api';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: null,
    users: [],
    isAuthenticated: !!localStorage.getItem('token')
  },
  mutations: { /*...*/ },
  actions: {
    async login({ commit }, credentials) { /*...*/ },
    async register({ commit }, userData) { /*...*/ },
    async getAllUsers({ commit }) { /*...*/ },
    logout({ commit }) { /*...*/ }
  }
});
```

**路由配置(src/router/index.js)**:
```javascript
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/login', name: 'Login', component: Login },
  { path: '/register', name: 'Register', component: Register },
  { path: '/users', name: 'UserList', component: UserList, meta: { requiresAuth: true } },
  { path: '/users/:id', name: 'UserDetail', component: UserDetail, meta: { requiresAuth: true } }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

// 导航守卫
router.beforeEach((to, from, next) => { /*...*/ });

export default router;
```

### 5. 核心页面组件

**登录页面(src/views/Login.vue)**:
- 用户名/密码表单
- 登录逻辑与错误处理
- 跳转到注册页的链接

**注册页面(src/views/Register.vue)**:
- 用户注册表单(用户名、密码、邮箱、手机)
- 表单验证
- 提交注册并处理响应

**用户列表页面(src/views/UserList.vue)**:
- 表格展示所有用户
- 分页功能
- 查看详情、编辑、删除操作

**用户详情页面(src/views/UserDetail.vue)**:
- 展示用户详细信息
- 编辑功能
- 返回列表功能

### 6. 实施时间表

**第1天**:
- 创建Vue前端项目
- 配置后端CORS支持
- 实现API服务层

**第2天**:
- 创建Vue路由和状态管理
- 实现登录和注册组件

**第3天**:
- 实现用户列表和用户详情组件
- 完善导航和样式

**第4天**:
- 测试前后端交互
- 修复问题和优化用户体验

## 后续计划

完成基础前后端对接后，可以继续进行：

1. **安全性增强**:
   - 实现JWT认证
   - 密码加密存储
   - 权限控制

2. **功能扩展**:
   - 用户角色管理
   - 密码重置功能
   - 用户头像上传

3. **性能优化**:
   - 响应式布局优化
   - 数据加载优化
   - 缓存策略
