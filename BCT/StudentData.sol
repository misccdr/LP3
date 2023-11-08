pragma solidity ^0.8.0;

contract StudentData {
    struct Student {
        uint studentID;
        string name;
        uint age;
    }

    Student[] public students;

    // Function to add a student
    function addStudent(uint _studentID, string memory _name, uint _age) public {
        Student memory newStudent = Student(_studentID, _name, _age);
        students.push(newStudent);
    }

    // Function to get the number of students stored
    function getNumberOfStudents() public view returns (uint) {
        return students.length;
    }

    // Fallback function
    fallback() external payable {
        // Fallback function logic, if any
        // This function is executed when a transaction is sent to the contract
    }

    receive() external payable {
        // Receive function logic, if any
        // This function is executed when the contract receives Ether
    }
}
