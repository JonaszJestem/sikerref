import React, {Component} from 'react';
import './styles.css';

class App extends Component {


    constructor(props) {
        super(props);

        this.handleSearchField = this.handleSearchField.bind(this);
        this.handleSearch = this.handleSearch.bind(this);
        this.renderOffers = this.renderOffers.bind(this);
    }

    state = {
        afterFirstSearch: false,
        searchQuery: "abc",
    };

    render() {
        this.handleSearch()
        let collapse = this.state.afterFirstSearch ? 'collapse' : '';
        return (
            <div className={"App " + collapse}>
                <form onSubmit={this.handleSearch}>
                    <input onChange={this.handleSearchField} value={this.state.searchQuery}
                           type="search"/>
                </form>
                <table>
                    {this.renderOffers()}
                </table>
            </div>
        );
    }

    renderOffers() {
        let contents = [];
        if (this.state.afterFirstSearch) {


            contents.push(<thead>
            <tr>
                <th>Image</th>
                <th>Title</th>
            </tr>
            </thead>);
            for (let i = 0; i < 3; i++) {
                contents.push(<tr>
                    <td>{this.state.offers[i].img}</td>
                    <td>{this.state.offers[i].title}</td>
                </tr>)
            }

        }
        return contents;
    }

    handleSearchField(event) {
        this.setState({searchQuery: event.target.value,});
    }

    async handleSearch(event) {
        let offers = await(await(this.getOffers())).json();

        this.setState({
            afterFirstSearch: true,
            searchQuery: "",
            offers: offers
        });
    }


    getOffers() {
        try {
            return fetch("http://localhost:3000/offers")
        }
        catch (e) {
            return {};
        }
    }
}

export default App;
