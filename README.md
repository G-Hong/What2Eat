<div align="center">

# What2Eat

<img src="https://github.com/username/What2Eat/raw/main/assets/logo.png" width="200" alt="What2Eat Logo">

**An AI-powered diet guide and nutritional checker based on Dr. Yongwoo Park's Switch-On Diet program**

[![GitHub stars](https://img.shields.io/github/stars/username/What2Eat?style=social)](https://github.com/username/What2Eat/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/username/What2Eat?style=social)](https://github.com/username/What2Eat/network/members)
[![GitHub license](https://img.shields.io/github/license/username/What2Eat?style=flat-square)](https://github.com/username/What2Eat/blob/main/LICENSE)
[![React](https://img.shields.io/badge/React-18.x-blue?style=flat-square&logo=react)](https://reactjs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=spring)](https://spring.io/projects/spring-boot)
[![Solar API](https://img.shields.io/badge/AI-Solar%20API-yellow?style=flat-square)](https://api.upstage.ai)

</div>

## 🌟 Overview

What2Eat is a comprehensive diet management application based on Dr. Yongwoo Park's Switch-On Diet program. The application provides personalized diet guidelines by calculating the user's current diet stage based on their starting date, weight, body fat, and muscle mass.

Switch-On Diet, developed by Dr. Yongwoo Park, a family medicine specialist at Kangbuk Samsung Hospital with 33 years of obesity treatment experience, has shown remarkable results with visible changes in just 4 weeks.

## ✨ Key Features

- 🍽️ **Diet Stage Calculation**: Automatically calculates and displays the current diet stage
- 🔍 **Food Permission Checker**: Verify if specific foods are allowed in your current diet stage
- 📊 **Weight Tracking**: Monitor your progress with weight, muscle mass, and body fat graphs
- 💬 **AI Diet Assistant**: Get answers to all your diet-related questions through our chatbot
- 📅 **Meal Reminder**: Notifications for meal times to keep you on track
- 🥗 **Recipe Recommendations**: Custom recipes based on allowed ingredients

## 🏗️ Architecture

The application follows a modern, microservice-based architecture:

```
┌─────────────────┐       ┌─────────────────┐       ┌─────────────────┐
│   React Client  │       │   Spring Boot   │       │    Solar AI     │
│                 │◄─────►│    REST API     │◄─────►│      Model      │
└─────────────────┘       └─────────────────┘       └─────────────────┘
        ▲                         ▲
        │                         │
        │                  ┌─────────────┐
        └─────────────────┤   MySQL DB   │
                          └─────────────┘
```

## 💻 Tech Stack

### Frontend
- React.js with React Router
- Chart.js for data visualization
- Axios for API requests
- Styled with TailwindCSS

### Backend
- Spring Boot REST API
- Spring Data JPA
- JWT Authentication
- MySQL Database

### AI Integration
- Solar API for knowledge-based responses
- Knowledge base constructed with Dr. Park's diet guidelines
- Domain-specific prompt engineering

## 🚀 Getting Started

### Prerequisites
- Node.js (v14.0+)
- Java 17+
- MySQL
- Solar API key

### Installation

1. Clone the repository
```bash
git clone https://github.com/username/What2Eat.git
cd What2Eat
```

2. Set up the backend
```bash
cd backend
./gradlew bootRun
```

3. Set up the frontend
```bash
cd frontend
npm install
npm start
```

4. Configure the environment variables
```
# Backend .env
DB_URL=jdbc:mysql://localhost:3306/what2eat
DB_USERNAME=root
DB_PASSWORD=password
SOLAR_API_KEY=your_solar_api_key

# Frontend .env
REACT_APP_API_BASE_URL=http://localhost:8080
```

## 📊 Database Schema

The application uses a relational database with the following structure:

```
userlist
- user_id (PK): varchar(25)
- password: varchar(25)

userInfo
- user_id (PK, FK): varchar(25)
- start_date: date
- step: int
- step_day: int
- goal: float
- day: int

graph
- id (PK): int
- user_id (FK): varchar
- date: date
- weight: float
- bodyMass: float
- musleMass: float
```

## 📱 Screenshots

<div align="center">
<img src="https://github.com/username/What2Eat/raw/main/assets/screenshots/login.png" width="200" alt="Login Screen">
<img src="https://github.com/username/What2Eat/raw/main/assets/screenshots/dashboard.png" width="200" alt="Dashboard">
<img src="https://github.com/username/What2Eat/raw/main/assets/screenshots/chat.png" width="200" alt="Chatbot">
<img src="https://github.com/username/What2Eat/raw/main/assets/screenshots/graph.png" width="200" alt="Progress Graph">
</div>

## 📋 Project Timeline

| Week | Backend | Frontend | AI Development | Data Analysis |
|------|---------|----------|----------------|---------------|
| Week 1 | Server setup & DB design | Wireframe design | Rule-based logic design | Data collection & analysis |
| Week 2 | User management APIs | React structure setup | Allowance criteria testing | Data preprocessing & rules establishment |
| Week 3 | Food allowance & notification APIs | Basic screen implementation | Rule-based data validation | Food database construction |
| Week 4 | Diet progress status APIs | Diet plan screen implementation | Backend rule integration | Data visualization |
| Week 5 | Text processing & result APIs | UI optimization | Notification logic enhancement | User feedback integration |
| Week 6 | Backend/Frontend integration | Responsive design application | Performance optimization | Accuracy testing & integration |
| Week 7 | Deployment setup | Final UI refinement | Final logic testing | Final report compilation |

## 🤝 Contributors

- **Project Lead, AI Developer**: [Gina Hong](https://github.com/G-Hong)
- **Frontend Developer**: [Frontend Dev Name](https://github.com/frontenddev)
- **Backend Developer**: [Backend Dev Name](https://github.com/backenddev)
- **AI Developer**: [AI Dev Name](https://github.com/aidev)
- **Data Analyst**: [Data Analyst Name](https://github.com/dataanalyst)

## 🔍 Why Solar API?

After evaluating several options, we chose Solar API for our AI assistant implementation because:

1. **Efficient Knowledge Base Handling**: Solar API provides superior context handling without token limitations
2. **Faster Response Time**: Lower latency compared to alternatives, crucial for real-time chat interactions
3. **Domain-Specific Optimization**: Better performance with our structured dietary knowledge base
4. **Format Control**: More consistent output formatting, essential for our rule-based responses

Instead of using RAG, we implemented a dictionary-based approach for efficient classification of allowed/prohibited foods at different diet stages.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgements

- Dr. Yongwoo Park for the Switch-On Diet program and guidance
- Kangbuk Samsung Hospital for the nutritional data
- Upstage for providing the Solar API
- All beta testers who provided valuable feedback

---

<div align="center">
Made with ❤️ for healthier eating
</div>
