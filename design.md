# Thiết kế kiến trúc RESTful

## Hệ thống cần quản lý Task (Công việc) và User (Người dùng), mỗi công việc thuộc về một người dùng

### Nhiệm vụ: Viết file design.md thiết kế các Endpoint sau (đảm bảo dùng danh từ số nhiều, đúng Method):

1. Lấy toàn bộ danh sách công việc, người dùng.

| Method | Endpoint | Mô tả |
| ------ | -------- |---|
| GET | /tasks   |Lấy toàn bộ danh sách công việc |
| GET | /users   |Lấy toàn bộ danh sách người dùng|

2. Tạo mới công việc, tạo mới người dùng

| Method | Endpoint | Mô tả |
| ------ | -------- |---|
| POST | /tasks   |Tạo mới một công việc |
| POST | /users   |Tạo mới một người dùng| 

3. Cập nhật trạng thái một công việc, cập nhật vai trò của người dùng.

| Method | Endpoint | Mô tả |
| ------ | ------ |---|
| PUT | /tasks/{taskId}/status  |Cập nhật trạng thái một công việc |
| PUT | /users/{userId}/role  |Cập nhật vai trò của người dùng| 

4. Xóa một công việc, xóa một người dùng khỏi hệ thống.

| Method | Endpoint | Mô tả |
| ------ | ------ |---|
| DELETE | /tasks/{taskId}  |Xóa một công việc theo id|
| DELETE | /users/{userId}  |Xóa một người dùng theo id| 

5. Tìm các công việc có mức độ ưu tiên là "high".

| Method | Endpoint | Mô tả |
| ------ | ------ |---|
| GET | /tasks?priority=high  |Tìm các công việc có mức độ ưu tiên là "high"|

6. Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1

| Method | Endpoint                  | Mô tả |
| ------ |---------------------------|---|
| GET | /tasks?priority=high&id=1 |Tìm các công việc priority "high" và giao cho user id = 1| 

7. Liệt kê toàn bộ công việc của 1 người dùng.

| Method | Endpoint | Mô tả |
| ------ | ------ |---|
| GET | /users/{userId}/tasks  |Liệt kê toàn bộ công việc của một người dùng| 

8. Gắn công việc cho người dùng.

| Method | Endpoint | Mô tả |
| ------ | ------ |---|
| PUT | /tasks/{taskId}/assignedTo|Gắn công việc cho người dùng|




















