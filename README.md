# ShiftApp

Приложение для отображения списка пользователей (https://randomuser.me) с возможностью просмотра детальной информации.

## 📱 Основные функции

- Просмотр списка пользователей (ФИО, фото, адрес, телефон)
- Детальная информация о пользователе
- Кэширование данных при отсутствии интернета
- Обновление данных (pull-to-refresh и кнопка)
- Открытие данных в сторонних приложениях (телефон, карта, почта)
- Переключение темы (темная/светлая)
- Возможность поделиться информацией о пользователе

## 🛠 Технологии

### UI
| Библиотека | Назначение | Преимущества |
|------------|------------|--------------|
| **Jetpack Compose** | Построение UI | Декларативный подход, перерисовка только измененных элементов |
| **Material 3** | Стилизация | Современные компоненты, поддержка тем |
| **Coil** | Загрузка изображений | Оптимизирован для Compose, кэширование |

### Данные
| Библиотека | Назначение | Преимущества |
|------------|------------|--------------|
| **Room** | Локальное хранилище | ORM с поддержкой Kotlin Coroutines |
| **Retrofit + Gson** | Сетевые запросы | Удобные аннотации |
| **DataStore** | Настройки темы | Замена SharedPreferences, асинхронность |

### Другие
| Библиотека | Назначение | Преимущества |
|------------|------------|--------------|
| **Hilt** | DI | Легкость в эксплуатации |
| **Navigation Compose** | Навигация | Type-safe навигация для Compose |
| **Accompanist SwipeRefresh** | Pull-to-refresh | Решение для конкретной задачи |

## 🎨 Особенности интерфейса

1. **Главный экран**:
   - Список из 50 пользователей с сокращенной информацией
   - Кнопка обновления и переключения темы
   - Pull-to-refresh

2. **Экран с детализированной информацией**:
   - Полная информация о пользователе
   - Кликабельные контакты (подчеркнуты)
   - Кнопка "Поделиться"
   - Уведомление при наличии проблем с открытием сторонних приложений (Toast)

3. **Темы**:
   - Поддержка светлой/темной темы
   - Сохранение выбора между сеансами

## 🔄 Логика работы с данными

1. **При первом запуске**:
   - Загрузка данных с API
   - Сохранение в локальную БД

2. **При обновлении**:
   - Принудительная загрузка новых данных
   - Обновление кэша

3. **Без интернета**:
   - Показ кэшированных данных
   - Уведомление о проблеме (Toast)

## 📸 Скриншоты

  <div style="display: flex; justify-content: space-around;">
    <img src="https://github.com/user-attachments/assets/7fe5d90d-e75d-4cd4-81cd-6f79b1113973" alt="1" width="200" />
    <img src="https://github.com/user-attachments/assets/5035e52b-b902-4d5a-90bc-1b96be4dc72f" alt="2" width="200" />
    <img src="https://github.com/user-attachments/assets/6dc5b2bf-bca3-4619-a33e-4b82100b19c7" alt="3" width="200" />
  </div> <div style="display: flex; justify-content: space-around;">
        <img src="https://github.com/user-attachments/assets/8863c273-9ad3-4988-8959-3cce34522880" alt="1" width="200" />
        <img src="https://github.com/user-attachments/assets/7fc26731-2dc5-4c22-a295-6ce14e0074bb0" alt="2" width="200" />
        <img src="https://github.com/user-attachments/assets/7835f353-8a80-49f1-8590-3fd04a3ae579" alt="3" width="200" />
    </div>


